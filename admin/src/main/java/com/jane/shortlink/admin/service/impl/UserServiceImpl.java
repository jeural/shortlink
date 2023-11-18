package com.jane.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jane.shortlink.admin.common.convention.ClientException;
import com.jane.shortlink.admin.dao.entity.UserDO;
import com.jane.shortlink.admin.dao.mapper.UserMapper;
import com.jane.shortlink.admin.dto.req.UserLoginReqDTO;
import com.jane.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.jane.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.jane.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.jane.shortlink.admin.dto.resp.UserRespDto;
import com.jane.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.jane.shortlink.admin.common.constant.RedisCacheConstant.LOCK_USER_REGISTER_KEY;
import static com.jane.shortlink.admin.common.enums.UserErrorCoreEnum.USER_NAME_EXIST;
import static com.jane.shortlink.admin.common.enums.UserErrorCoreEnum.USER_SAVE_ERROR;

/**
 * _@Description: 用户接口实现层
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy)) //构造器注入
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;
    private final RedissonClient redissonClient;
    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 根据用户名查找用户信息
     * */
    @Override
    public UserRespDto getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDo = baseMapper.selectOne(queryWrapper);
        UserRespDto result = new UserRespDto();
        BeanUtils.copyProperties(userDo, result);
        return result;
    }

    /**
     * 查询用户名是否存在
     */
    @Override
    public Boolean hasUsername(String username) {
        return userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void register(UserRegisterReqDTO requestParam) {
        // 用户名已存在
        if (hasUsername(requestParam.getUsername())) {
            throw new ClientException(USER_NAME_EXIST);
        }
        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER_KEY + requestParam.getUsername());
        try {
            if (lock.tryLock()) {
                // insert
                int insert = baseMapper.insert(BeanUtil.toBean(requestParam, UserDO.class));
                // 用户注册新增失败
                if (insert < 1) {
                    throw new ClientException(USER_SAVE_ERROR);
                }
                userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 根据用户名修改用户
     */
    @Override
    public void update(UserUpdateReqDTO requestParam) {
        //TODO 验证当前用户名是否为登录用户
        LambdaUpdateWrapper<UserDO> updateWrapper = Wrappers.lambdaUpdate(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername());
        baseMapper.update(BeanUtil.toBean(requestParam, UserDO.class), updateWrapper);
    }

    /**
     * 用户登录
     */
    @Override
    public UserLoginRespDTO login(UserLoginReqDTO requestParam) {

        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername())
                //.eq(UserDo::getPassword, requestParam.getPassword())
                .eq(UserDO::getDelFlag, 0);
        UserDO userDo = baseMapper.selectOne(queryWrapper);
        if (userDo == null) {
            throw new ClientException("用户不存在");
        }
        /*
         避免重复登录
         Hash -> key：login_用户名
                 Value： key-token标识
                         value-JSON字符串(用户信息)
         */
        Boolean hasLogin = stringRedisTemplate.hasKey("login_" + requestParam.getUsername());
        if (hasLogin != null && hasLogin) {
            throw new ClientException("用户已登录");
        }
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        stringRedisTemplate.opsForHash().put("login_" + requestParam.getUsername(), uuid, JSON.toJSONString(userDo));
        stringRedisTemplate.expire("login_" + requestParam.getUsername(), 30L, TimeUnit.MINUTES);
        return new UserLoginRespDTO(uuid);
    }

    /**
     * 检查用户是否登录
     */
    @Override
    public Boolean check_login(String username, String token) {
        return stringRedisTemplate.opsForHash().get("login_" + username,token) != null;
    }

    @Override
    public void logout(String username, String token) {
        // 验证是否登录
        if (check_login(username, token)) {
            stringRedisTemplate.delete("login_" + username);
            return;
        }
        throw new ClientException("用户token不存在或用户未登录");
    }
}

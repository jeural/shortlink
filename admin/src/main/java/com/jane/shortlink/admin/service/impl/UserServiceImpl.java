package com.jane.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jane.shortlink.admin.dao.mapper.UserMapper;
import com.jane.shortlink.admin.dto.resp.UserRespDto;
import com.jane.shortlink.admin.service.UserService;
import com.jane.shortlink.admin.common.convention.ClientException;
import com.jane.shortlink.admin.dao.entity.UserDo;
import com.jane.shortlink.admin.dto.req.UserRegisterReqDto;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import static com.jane.shortlink.admin.common.constant.RedisCacheConstant.LOCK_USER_REGISTER_KEY;
import static com.jane.shortlink.admin.common.enums.UserErrorCoreEnum.USER_NAME_EXIST;
import static com.jane.shortlink.admin.common.enums.UserErrorCoreEnum.USER_SAVE_ERROR;

/**
 * _@Description: 用户接口实现层
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy)) //构造器注入
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDo> implements UserService {

    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;
    private final RedissonClient redissonClient;
    /**
     * 根据用户名查找用户信息
     * */
    @Override
    public UserRespDto getUserByUsername(String username) {
        LambdaQueryWrapper<UserDo> queryWrapper = Wrappers.lambdaQuery(UserDo.class)
                .eq(UserDo::getUsername, username);
        UserDo userDo = baseMapper.selectOne(queryWrapper);
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
    public void register(UserRegisterReqDto requestParam) {
        // 用户名已存在
        if (hasUsername(requestParam.getUsername())) {
            throw new ClientException(USER_NAME_EXIST);
        }
        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER_KEY + requestParam.getUsername());
        try {
            if (lock.tryLock()) {
                // insert
                int insert = baseMapper.insert(BeanUtil.toBean(requestParam, UserDo.class));
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
}

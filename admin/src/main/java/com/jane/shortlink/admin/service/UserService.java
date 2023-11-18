package com.jane.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jane.shortlink.admin.dao.entity.UserDO;
import com.jane.shortlink.admin.dto.req.UserLoginReqDTO;
import com.jane.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.jane.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.jane.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.jane.shortlink.admin.dto.resp.UserRespDto;

/**
 * _@Description: 用户服务层接口
 */
public interface UserService extends IService<UserDO> {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return  用户返回实体
     */
    UserRespDto getUserByUsername(String username);

    /**
     * 查询用户名是否存在
     * @param username 用户名
     * @return 用户存在返回 ture--不可用 不存在 false--可用
     */
    Boolean hasUsername(String username);

    /**
     * 注册用户
     * @param requestParam 注册用户请求对象 *很多/不具体的对象requestParam命名
     */
    void register(UserRegisterReqDTO requestParam);

    /**
     * 根据用户名修改用户
     * @param requestParam 修改用户请求参数
     */
    void update(UserUpdateReqDTO requestParam);

    /**
     * 用户登录
     * @param requestParam 用户登录请求参数
     * @return 用户登录返回参数 Token
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    /**
     * 检查用户是否登录
     * @param username 用户名
     * @param token 用户登录 Token
     * @return 用户是否登录表示
     */
    Boolean check_login(String username, String token);

    /**
     * 用户退出登录
     * @param username 用户名
     * @param token 用户登录 Token
     */
    void logout(String username, String token);
}

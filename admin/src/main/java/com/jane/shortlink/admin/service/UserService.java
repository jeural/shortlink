package com.jane.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jane.shortlink.admin.dto.resp.UserRespDto;
import com.jane.shortlink.admin.dao.entity.UserDo;
import com.jane.shortlink.admin.dto.req.UserRegisterReqDto;

/**
 * _@Description: 用户服务层接口
 */
public interface UserService extends IService<UserDo> {
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
    void register(UserRegisterReqDto requestParam);
}

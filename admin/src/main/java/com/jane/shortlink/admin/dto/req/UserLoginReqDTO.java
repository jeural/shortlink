package com.jane.shortlink.admin.dto.req;

import lombok.Data;

/**
 * _@Description: 用户登录请求参数
 */
@Data
public class UserLoginReqDTO {

    private String username;
    private String password;
}

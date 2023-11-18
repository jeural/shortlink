package com.jane.shortlink.admin.dto.req;

import lombok.Data;

/**
 * _@Description: 用户注册请求参数
 */
@Data
public class UserRegisterReqDTO {
    private Long id;
    private String username;
    private String realName;
    private String phone;
    private String mail;
}

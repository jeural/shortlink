package com.jane.shortlink.admin.dto.req;

import lombok.Data;

/**
 * _@Description: 用户修改请求参数
 */
@Data
public class UserUpdateReqDTO {
    private String username;
    private String realName;
    private String phone;
    private String mail;
}

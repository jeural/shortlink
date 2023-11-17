package com.jane.shortlink.admin.dto.resp;

import lombok.Data;

/**
 * _@Description: 用户返回参数响应
 */
@Data
public class UserRespDto {
    private Long id;
    private String username;
    private String realName;
    private String phone;
    private String mail;
}

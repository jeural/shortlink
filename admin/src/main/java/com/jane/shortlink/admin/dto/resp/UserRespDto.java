package com.jane.shortlink.admin.dto.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jane.shortlink.admin.common.serialize.PhoneDesensitizationSerializer;
import lombok.Data;

/**
 * _@Description: 用户返回参数响应
 */
@Data
public class UserRespDto {
    private Long id;
    private String username;
    private String realName;
    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;
    private String mail;
}

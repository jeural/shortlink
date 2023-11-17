package com.jane.shortlink.admin.dto.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jane.shortlink.admin.common.serialize.PhoneDesensitizationSerializer;
import lombok.Data;

/**
 * _@Description: 用户未脱敏信息
 */
@Data
public class UserActualRespDo {
    private Long id;
    private String username;
    private String realName;
    private String phone;
    private String mail;
}

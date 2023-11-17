package com.jane.shortlink.admin.common.enums;

import com.jane.shortlink.admin.common.convention.errorcode.IErrorCode;

/**
 * _@Description: user相关异常
 */
public enum UserErrorCoreEnum implements IErrorCode {
    USER_NUll("B000200", "用户记录不存在"),
    USER_NAME_EXIST("B000201", "用户名已存在"),
    USER_EXIST("B000202", "用户记录已存在"),
    USER_SAVE_ERROR("B000202", "用户新增失败");


    private final String code;

    private final String message;

    UserErrorCoreEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}


package com.jane.shortlink.project.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * _@Description: 有效期类型
 */
@RequiredArgsConstructor
public enum VailDateTypeEnum {

    /**
     * 永久有效
     */
    PERMANENT(0),

    /**
     * 自定义有效期
     */
    CUSTOM(1);

    @Getter
    private final int type;
}

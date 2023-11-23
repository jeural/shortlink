package com.jane.shortlink.project.toolkit;

import cn.hutool.core.date.LocalDateTimeUtil;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.jane.shortlink.project.common.constant.ShortLinkConstant.DEFAULT_CACHE_VALID_TIME;

/**
 * _@Description: 短链接工具类
 */
public class LinkUtil {

    /**
     * 获取短链接缓存有效期时间
     * @param validDate 有效期时间
     * @return 有效期时间戳
     */
    public static long getLinkCatchValidDate(LocalDateTime validDate) {
        return Optional.ofNullable(validDate)
                .map(each -> LocalDateTimeUtil.between(LocalDateTime.now(), each).toMillis())
                .orElse(DEFAULT_CACHE_VALID_TIME);
    }
}

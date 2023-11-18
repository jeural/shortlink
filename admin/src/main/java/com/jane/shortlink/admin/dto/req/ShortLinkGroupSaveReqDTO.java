package com.jane.shortlink.admin.dto.req;

import lombok.Data;

/**
 * _@Description: 短链接分组创建参数
 */
@Data
public class ShortLinkGroupSaveReqDTO {
    /**
     * 分组名
     */
    private String name;
}

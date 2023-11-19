package com.jane.shortlink.admin.dto.req;

import lombok.Data;

/**
 * _@Description: 短链接分组排序参数
 */
@Data
public class ShortLinkGroupSortReqDTO {

    /**
     * 分组 ID
     */
    private String gid;

    /**
     * 分组排序
     */
    private Integer sortOrder;
}

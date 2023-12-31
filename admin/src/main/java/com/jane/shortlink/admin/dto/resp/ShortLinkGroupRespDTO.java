package com.jane.shortlink.admin.dto.resp;

import lombok.Data;

/**
 * _@Description: 短链接分组返回实体对象
 */
@Data
public class ShortLinkGroupRespDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 分组排序
     */
    private Integer sortOrder;

    /**
     * 当前分组短链接数量
     */
    private Integer shortLinkCount;
}

package com.jane.shortlink.admin.dto.req;

import lombok.Data;

/**
 * _@Description: 短链接分组修改参数
 */
@Data
public class ShortLinkGroupUpdateReqDTO {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名
     */
    private String name;
}

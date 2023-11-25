package com.jane.shortlink.admin.remote.dto.req;

import lombok.Data;

/**
 * _@Description: 回收站保存请求对象
 */
@Data
public class RecycleBinSaveRepDTO {

    /**
     * 分组标识
     */
    private String gid;
    /**
     * 完整短链接
     */
    private String fullShortUrl;
}

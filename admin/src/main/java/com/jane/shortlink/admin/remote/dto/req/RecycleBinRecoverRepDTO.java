package com.jane.shortlink.admin.remote.dto.req;

import lombok.Data;

/**
 * _@Description: 回收站短链接恢复请求对象
 */
@Data
public class RecycleBinRecoverRepDTO {

    /**
     * 分组标识
     */
    private String gid;
    /**
     * 完整短链接
     */
    private String fullShortUrl;
}

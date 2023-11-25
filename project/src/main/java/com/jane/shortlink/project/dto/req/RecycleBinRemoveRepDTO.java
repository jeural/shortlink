package com.jane.shortlink.project.dto.req;

import lombok.Data;

/**
 * _@Description: 回收站短链接删除请求对象
 */
@Data
public class RecycleBinRemoveRepDTO {

    /**
     * 分组标识
     */
    private String gid;
    /**
     * 完整短链接
     */
    private String fullShortUrl;
}

package com.jane.shortlink.project.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jane.shortlink.project.dao.entity.ShortLinkDO;
import lombok.Data;

/**
 * _@Description: 短链接请求参数
 */
@Data
public class ShortLinkPageReqDTO extends Page<ShortLinkDO> {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 排序标识
     */
    private String orderTag;
}

package com.jane.shortlink.project.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jane.shortlink.project.dao.entity.LinkAccessLogsDO;
import lombok.Data;

/**
 * _@Description: 分组短链接监控访问记录请求参数
 */
@Data
public class ShortLinkGroupStatsAccessRecordReqDTO extends Page<LinkAccessLogsDO> {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;
}
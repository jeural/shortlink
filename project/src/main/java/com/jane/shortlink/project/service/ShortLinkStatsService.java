package com.jane.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jane.shortlink.project.dto.req.ShortLinkGroupStatsReqDTO;
import com.jane.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import com.jane.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.jane.shortlink.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.jane.shortlink.project.dto.resp.ShortLinkStatsRespDTO;

/**
 * _@Description: 短链接监控接口层
 */
public interface ShortLinkStatsService {

    /**
     * 获取单个短链接监控数据
     * @param requestParam 获取短链接监控数据入参
     * @return 短链接监控数据
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);

    /**
     * 获取分组短链接监控数据
     *
     * @param requestParam 获取分组短链接监控数据入参
     * @return 分组短链接监控数据
     */
    ShortLinkStatsRespDTO groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam);

    /**
     * 访问单个短链接指定时间内访问监控数据
     * @param requestParam 获取短链接监控访问记录请求参数
     * @return 短链接监控访问记录结果
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);
}
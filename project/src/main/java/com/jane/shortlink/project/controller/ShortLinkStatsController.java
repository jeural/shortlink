package com.jane.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jane.shortlink.project.common.convention.result.Result;
import com.jane.shortlink.project.common.convention.result.Results;
import com.jane.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import com.jane.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.jane.shortlink.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.jane.shortlink.project.dto.resp.ShortLinkStatsRespDTO;
import com.jane.shortlink.project.service.ShortLinkStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * _@Description: 短链接监控控制层
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {

    private final ShortLinkStatsService shortLinkStatsService;

    /**
     * 访问单个短链接指定时间内监控数据
     */
    @GetMapping("/api/short-link/v1/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.oneShortLinkStats(requestParam));
    }

    /**
     * 访问单个短链接指定时间内访问监控数据
     */
    @GetMapping("/api/short-link/v1/stats/access-record")
    public Result<IPage<ShortLinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam) {
        return Results.success(shortLinkStatsService.shortLinkStatsAccessRecord(requestParam));
    }
}
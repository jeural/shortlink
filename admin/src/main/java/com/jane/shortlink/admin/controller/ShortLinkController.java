package com.jane.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jane.shortlink.admin.common.convention.result.Result;
import com.jane.shortlink.admin.common.convention.result.Results;
import com.jane.shortlink.admin.remote.dto.ShortLinkRemoteService;
import com.jane.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import com.jane.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import com.jane.shortlink.admin.remote.dto.req.ShortLinkUpdateReqDTO;
import com.jane.shortlink.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import com.jane.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.springframework.web.bind.annotation.*;

/**
 * _@Description: 短链接后管控制层
 */
@RestController
public class ShortLinkController {

    /**
     * TODO: 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService(){
    };

    /**
     * 创建短链接
     */
    @PostMapping("/api/short-link/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return shortLinkRemoteService.createShortLink(requestParam);
    }

    /**
     * 修改短链接
     */
    @PostMapping("/api/short-link/admin/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        shortLinkRemoteService.updateShortLink(requestParam);
        return Results.success();
    }

    /**
     * 短链接分页查询
     */
    @GetMapping("/api/short-link/admin/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(@RequestBody ShortLinkPageReqDTO requestParam) {
        return shortLinkRemoteService.pageShortLink(requestParam);
    }
}

package com.jane.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jane.shortlink.admin.common.convention.result.Result;
import com.jane.shortlink.admin.common.convention.result.Results;
import com.jane.shortlink.admin.remote.dto.ShortLinkRemoteService;
import com.jane.shortlink.admin.remote.dto.req.RecycleBinRecoverRepDTO;
import com.jane.shortlink.admin.remote.dto.req.RecycleBinSaveRepDTO;
import com.jane.shortlink.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.jane.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import com.jane.shortlink.admin.service.RecycleBinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * _@Description: 回收站管理控制层
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {

    private final RecycleBinService recycleBinService;

    /**
     * TODO: 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService(){
    };

    /**
     * 移至回收站
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(RecycleBinSaveRepDTO requestParam) {
        shortLinkRemoteService.saveRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 分页查询回收站短链接
     */
    @GetMapping("/api/short-link/admin/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
        return recycleBinService.pageRecycleBinShortLink(requestParam);
    }

    /**
     * 恢复短链接
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/recover")
    public Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverRepDTO requestParam) {
        shortLinkRemoteService.recoverRecycleBin(requestParam);
        return Results.success();
    }
}

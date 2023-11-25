package com.jane.shortlink.admin.controller;

import com.jane.shortlink.admin.common.convention.result.Result;
import com.jane.shortlink.admin.common.convention.result.Results;
import com.jane.shortlink.admin.remote.dto.ShortLinkRemoteService;
import com.jane.shortlink.admin.remote.dto.req.RecycleBinSaveRepDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * _@Description: 回收站管理控制层
 */
@RestController
public class RecycleBinController {

    /**
     * TODO: 后续重构为 SpringCloud Feign 调用
     */
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService(){
    };

    @PostMapping("/api/short-link/admin/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(RecycleBinSaveRepDTO requestParam) {
        shortLinkRemoteService.saveRecycleBin(requestParam);
        return Results.success();
    }
}

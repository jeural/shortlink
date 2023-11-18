package com.jane.shortlink.admin.controller;

import com.jane.shortlink.admin.common.convention.result.Result;
import com.jane.shortlink.admin.common.convention.result.Results;
import com.jane.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.jane.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * _@Description: 短链接分组控制层
 */
@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    /**
     * 新增短链接分组
     */
    @PostMapping("/api/short-link/admin/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO requestParam) {
        groupService.savaGroup(requestParam.getName());
        return Results.success();
    }
}

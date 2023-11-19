package com.jane.shortlink.admin.controller;

import com.jane.shortlink.admin.common.convention.result.Result;
import com.jane.shortlink.admin.common.convention.result.Results;
import com.jane.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.jane.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.jane.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.jane.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 查询用户短链接分组集合
     */
    @GetMapping("/api/short-link/admin/v1/group")
    public Result<List<ShortLinkGroupSaveReqDTO>> listGroup() {
        return Results.success(groupService.listGroup());
    }

    /**
     * 修改短链接分组名
     */
    @PutMapping("/api/short-link/admin/v1/group")
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam) {
        groupService.updateGroup(requestParam);
        return Results.success();
    }

    /**
     * 删除短链接分组名
     */
    @DeleteMapping("/api/short-link/admin/v1/group")
    public Result<Void> deleteGroup(@RequestParam String gid) {
        groupService.deleteGroup(gid);
        return Results.success();
    }

    /**
     * 短链接分组排序
     */
    @PostMapping("/api/short-link/admin/v1/sort")
    public Result<Void> sortOrder(@RequestBody List<ShortLinkGroupSortReqDTO> requestParam) {
        groupService.sortOrder(requestParam);
        return Results.success();
    }
}

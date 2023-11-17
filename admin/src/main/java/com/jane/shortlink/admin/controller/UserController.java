package com.jane.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.jane.shortlink.admin.common.convention.result.Result;
import com.jane.shortlink.admin.common.convention.result.Results;
import com.jane.shortlink.admin.dto.resp.UserRespDto;
import com.jane.shortlink.admin.service.UserService;
import com.jane.shortlink.admin.dto.req.UserRegisterReqDto;
import com.jane.shortlink.admin.dto.resp.UserActualRespDo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * _@Description: 用户管理控制层
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    /**
     * 根据用户名查询用户脱敏信息
     */
    @GetMapping("/api/short-link/v1/user/{username}")
    public Result<UserRespDto> getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    /**
     * 根据用户名查询用户真实信息
     */
    @GetMapping("/api/short-link/v1/actual/user/{username}")
    public Result<UserActualRespDo> getActualUserByUsername(@PathVariable("username") String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDo.class));
    }

    /**
     * 查询用户名是否存在
     */
    @GetMapping("/api/short-link/v1/user/has_username")
    public Result<Boolean> hasUsername(@RequestParam("username") String username) {
        return Results.success(!userService.hasUsername(username));
    }

    /**
     * 注册用户
     */
    @PostMapping("/api/short-link/admin/v1/user")
    public Result<Void> register(@RequestBody UserRegisterReqDto requestParam) {
        userService.register(requestParam);
        return Results.success();
    }
}

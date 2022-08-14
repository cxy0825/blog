package com.cxy.blog.controller;

import com.cxy.blog.service.SysUserService;
import com.cxy.blog.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Resource
@RequestMapping("users")
public class UserController {

    @Resource
    private SysUserService sysUserService;

    @PostMapping("currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token) {
        return sysUserService.findUserByToken(token);
    }
}

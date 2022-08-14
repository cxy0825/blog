package com.cxy.blog.service;

import com.cxy.blog.vo.Result;
import com.cxy.blog.vo.params.LoginParams;

public interface LoginService {
    /*
     *登录功能
     *@Param: [loginParams]
     *@Return: com.cxy.blog.vo.Result
     */
    Result login(LoginParams loginParams);
}

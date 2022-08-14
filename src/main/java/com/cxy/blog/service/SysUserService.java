package com.cxy.blog.service;

import com.cxy.blog.dao.POPJ.SysUser;
import com.cxy.blog.vo.Result;

public interface SysUserService {
    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    /*
     *根据token去查询用户信息
     *@Param: [token]
     *@Return: com.cxy.blog.vo.Result
     */
    Result findUserByToken(String token);
}

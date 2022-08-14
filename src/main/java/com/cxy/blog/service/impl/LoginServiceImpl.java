package com.cxy.blog.service.impl;

import com.cxy.blog.dao.POPJ.SysUser;
import com.cxy.blog.service.LoginService;
import com.cxy.blog.service.SysUserService;
import com.cxy.blog.utils.JWTUtils;
import com.cxy.blog.vo.ErrorCode;
import com.cxy.blog.vo.Result;
import com.cxy.blog.vo.params.LoginParams;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private SysUserService sysUserService;

    @Override
    public Result login(LoginParams loginParams) {
        /*
         *1.检查参数是否合法
         * 2.根据账号密码去user表中查询
         * 3.如果不存在登录失败
         * 4.如果存在，使用jwt生成token，返回前端
         *@Param: [loginParams]
         *@Return: com.cxy.blog.vo.Result
         */
        String account = loginParams.getAccount();
        String password = loginParams.getPassword();
        if (account == null || password == null) {
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        SysUser sysUser = sysUserService.findUser(account, password);

        if (sysUser == null) {
            return Result.fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }

        HashMap<String, Object> User = new HashMap<>();
        User.put("userId", sysUser.getId());
        User.put("userAccount", sysUser.getAccount());
        User.put("getNickname", sysUser.getNickname());
        String token = JWTUtils.createJWT(User);

        return Result.success(token);
    }
}

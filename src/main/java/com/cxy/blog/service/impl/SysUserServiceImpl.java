package com.cxy.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cxy.blog.dao.POPJ.SysUser;
import com.cxy.blog.dao.mapper.SysUserMapper;
import com.cxy.blog.service.SysUserService;
import com.cxy.blog.vo.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setNickname("默认名字");
        }
        return sysUser;
    }

    @Override
    public SysUser findUser(String account, String password) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getAccount, account).
                eq(SysUser::getPassword, password).
                select(SysUser::getAccount, SysUser::getId, SysUser::getAvatar, SysUser::getNickname).
                last("limit 1");

        return sysUserMapper.selectOne(wrapper);
    }

    @Override
    public Result findUserByToken(String token) {
        return null;
    }
}

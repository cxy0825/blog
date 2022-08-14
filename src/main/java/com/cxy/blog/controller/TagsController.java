package com.cxy.blog.controller;

import com.cxy.blog.service.TagService;
import com.cxy.blog.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tags")
public class TagsController {
    @Resource
    private TagService tagService;

    //最热标签
    @GetMapping("/hot")
    public Result hot() {
        int limit = 6;
        return tagService.hots(limit);
    }
}

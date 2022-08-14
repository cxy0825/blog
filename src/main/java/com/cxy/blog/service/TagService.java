package com.cxy.blog.service;

import com.cxy.blog.vo.Result;
import com.cxy.blog.vo.TagVo;

import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);
}

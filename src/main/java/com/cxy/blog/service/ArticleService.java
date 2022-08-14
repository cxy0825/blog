package com.cxy.blog.service;

import com.cxy.blog.vo.Result;
import com.cxy.blog.vo.params.PageParams;

public interface ArticleService {
    /**
     * 分页查询 文章列表
     *
     * @Param:
     * @Return:
     */
    Result listArticle(PageParams pageParams);

    Result hotArticles(int limit);
}

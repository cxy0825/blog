package com.cxy.blog.controller;

import com.cxy.blog.service.ArticleService;
import com.cxy.blog.vo.Result;
import com.cxy.blog.vo.params.PageParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("articles")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    /**
     * 文章列表
     *
     * @Param: [pageParams]
     * @Return: com.cxy.blog.VO.Result
     */
    @PostMapping
    public Result listArticles(@RequestBody PageParams pageParams) {
        return articleService.listArticle(pageParams);
    }

    /*
     *最热文章
     *@Param: [pageParams]
     *@Return: com.cxy.blog.vo.Result
     */
    @PostMapping("hot")
    public Result hotArticles() {
        int limit = 5;
        return articleService.hotArticles(limit);
    }


}

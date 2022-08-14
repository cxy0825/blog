package com.cxy.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxy.blog.dao.POPJ.Article;
import com.cxy.blog.dao.mapper.ArticleMapper;
import com.cxy.blog.service.ArticleService;
import com.cxy.blog.service.SysUserService;
import com.cxy.blog.service.TagService;
import com.cxy.blog.vo.ArticleVo;
import com.cxy.blog.vo.Result;
import com.cxy.blog.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private TagService tagService;
    @Resource
    private SysUserService sysUserService;

    @Override
    public Result listArticle(PageParams pageParams) {
        //分页查询数据库article表
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        //置顶排序
        //时间排序
        wrapper.orderByDesc(Article::getWeight, Article::getCreate_date);
        Page<Article> articlePage = articleMapper.selectPage(page, wrapper);
        List<Article> records = articlePage.getRecords();
        //转成vo对象
        List<ArticleVo> articleVoList = copyList(records, true, true);
        return Result.success(articleVoList);
    }

    @Override
    public Result hotArticles(int limit) {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        //置顶排序
        //时间排序
        wrapper.orderByDesc(Article::getView_counts);
        wrapper.select(Article::getId, Article::getTitle);
        wrapper.last("limit " + limit);
        List<Article> articles = articleMapper.selectList(wrapper);
        return Result.success(copyList(articles, false, false));
    }

    private List<ArticleVo> copyList(List<Article> articles, boolean isTag, boolean isAuthor) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article article : articles) {
            articleVoList.add(copy(article, isTag, isAuthor));
        }
        return articleVoList;
    }


    //把相同属性的值拷贝到ArticleVo上
    private ArticleVo copy(Article article, boolean isTag, boolean isAuthor) {
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        //因为ArticleVo中createDate是string型，popj中是Long要进行转换
        articleVo.setCreateDate(new DateTime(article.getCreate_date()).toString("yyyy-MM-dd HH:mm"));
        //不是所有的接口都需要标签和作者信息的
        if (isTag) {
            Long articleId = article.getId();
            articleVo.setTags(tagService.findTagsByArticleId(articleId));
        }
        if (isAuthor) {
            Long author_id = article.getAuthor_id();
            articleVo.setAuthor(sysUserService.findUserById(author_id).getNickname());
        }
        return articleVo;
    }
}

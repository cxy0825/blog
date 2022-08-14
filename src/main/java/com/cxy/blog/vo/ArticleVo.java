package com.cxy.blog.vo;

import lombok.Data;

import java.util.List;

@Data
public class ArticleVo {

    private Long id;

    private String title;

    private String summary;

    private Integer commentCounts;

    private Integer viewCounts;
    private Integer weight;
    /**
     * 创建时间
     */
    private String createDate;
    /**
     * 作者id
     */
    private String author;

    private List<TagVo> tags;
}


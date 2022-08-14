package com.cxy.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxy.blog.dao.POPJ.Tag;

import java.util.List;


public interface TagMapper extends BaseMapper<Tag> {
    /*
     *根据文章ID查找标签列表
     *@Param: [articleId]
     *@Return: java.util.List<com.cxy.blog.dao.POPJ.Tag>
     */
    List<Tag> findTagsByArticleId(Long articleId);

    /*
     *根据文章ID数组查找标签列表
     *@Param: [tagIds]
     *@Return: java.util.List<com.cxy.blog.dao.POPJ.Tag>
     */
    List<Tag> findTagsByArticleIds(List<Long> tagIds);

    /*
     *查询最热ID 前limit条
     *@Param: [limit]
     *@Return: java.util.List<java.lang.Long>
     */
    List<Long> findHotsTagIds(int limit);


}

package com.cxy.blog.service.impl;

import com.cxy.blog.dao.POPJ.Tag;
import com.cxy.blog.dao.mapper.TagMapper;
import com.cxy.blog.service.TagService;
import com.cxy.blog.vo.Result;
import com.cxy.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        List<Tag> tagList = tagMapper.findTagsByArticleId(articleId);

        return copyList(tagList);
    }

    @Override
    public Result hots(int limit) {
        /*
         *拥有文章数量最多的标签数
         * 根据tag_id 分组 计数 从大到小排列
         *@Param: [limit]
         *@Return: com.cxy.blog.vo.Result
         */
        List<Long> tagIds = tagMapper.findHotsTagIds(limit);
        if (CollectionUtils.isEmpty(tagIds)) {
            return Result.success(Collections.emptyList());
        }
        List<Tag> tagList = tagMapper.findTagsByArticleIds(tagIds);
        return Result.success(tagList);
    }

    private List<TagVo> copyList(List<Tag> tags) {
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tags) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }


    private TagVo copy(Tag tag) {
        TagVo TagVo = new TagVo();
        BeanUtils.copyProperties(tag, TagVo);

        return TagVo;
    }
}

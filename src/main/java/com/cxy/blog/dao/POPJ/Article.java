package com.cxy.blog.dao.POPJ;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("ms_article")
public class Article {
    public Long id;
    public Integer comment_counts;
    public Integer create_date;
    public String summary;
    public String title;
    public Integer view_counts;
    public Integer weight;
    public Long author_id;
    public Long body_id;
    public Long category_id;
}

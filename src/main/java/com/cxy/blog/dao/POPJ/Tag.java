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
@TableName("ms_tag")
public class Tag {
    public Long id;
    public Long article_id;
    public Long tag_id;
}

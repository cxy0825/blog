package com.cxy.blog.vo.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageParams {
    //默认页数
    private int page = 1;
    //默认每一页数据条数
    private int pageSize = 10;
}

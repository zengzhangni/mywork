package com.aliyun.cs.mapper;

import com.aliyun.cs.model.Recommend;
import com.aliyun.cs.utils.base.BaseMapper;

/**
 * @author zengzhangni
 * @date 2019/7/22
 */
public interface RecommendMapper extends BaseMapper<Recommend> {


    Recommend getByMemberUuid(String memberUuid);

}

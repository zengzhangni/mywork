package com.aliyun.cs.mapper;

import com.aliyun.cs.model.Trace;
import com.aliyun.cs.utils.base.BaseMapper;

import java.util.List;

/**
 * @author zengzhangni
 * @date 2019/7/22
 */
public interface TraceMapper extends BaseMapper<Trace> {

    List<Integer> getByMemberUuid(String memberUuid);

}

package com.aliyun.cs.mapper;


import com.aliyun.cs.model.Member;
import com.aliyun.cs.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
public interface MemberMapper extends BaseMapper<Member> {

    List<Member> findByPageForFront(@Param("keyWord") String keyWord);

    List<Member> findByConditions();

}
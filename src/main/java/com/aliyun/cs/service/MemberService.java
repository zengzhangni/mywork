package com.aliyun.cs.service;

import com.aliyun.cs.model.Member;
import com.aliyun.cs.utils.base.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
public interface MemberService extends BaseService<Member> {

    PageInfo<Member> findByPageForFront(Integer pageNo, Integer pageSize, String keyWord);

    List<Member> findByConditions();

    Integer add(Member member);

    void delete(List<Integer> indexList);

}

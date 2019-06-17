package com.aliyun.cs.service;

import com.aliyun.cs.model.Member;
import com.aliyun.cs.util.ResponseMessage;
import com.aliyun.cs.util.SpringCloudBaseService;
import com.github.pagehelper.PageInfo;

/**
 * @author liyang
 * @version 1.0 2019年3月5日
 */
public interface MemberService extends SpringCloudBaseService<Member> {

    ResponseMessage<PageInfo<Member>> findByPageForFront(Integer pageNo, Integer pageSize, Member member);
}

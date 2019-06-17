package com.aliyun.cs.service.impl;

import com.aliyun.cs.mapper.MemberMapper;
import com.aliyun.cs.model.Member;
import com.aliyun.cs.service.MemberService;
import com.aliyun.cs.utils.base.BaseServiceImpl;
import com.aliyun.cs.utils.base.ResponseMessage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liyang
 * @version 1.0 2019年3月5日
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl extends BaseServiceImpl<Member> implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Override
    public ResponseMessage<PageInfo<Member>> findByPageForFront(Integer pageNo, Integer pageSize, Member member) {
        PageHelper.startPage(pageNo, pageSize);
        List<Member> members = memberMapper.selectListByConditions(member);
        return new ResponseMessage<>(new PageInfo<>(members));
    }
}
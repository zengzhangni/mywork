package com.aliyun.cs.service.impl;


import com.aliyun.cs.mapper.MemberMapper;
import com.aliyun.cs.model.Member;
import com.aliyun.cs.service.MemberService;
import com.aliyun.cs.utils.base.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl extends BaseServiceImpl<Member> implements MemberService {


    @Resource
    private MemberMapper memberMapper;

    @Override
    public PageInfo<Member> findByPageForFront(Integer pageNo, Integer pageSize, String keyWord) {
        PageHelper.startPage(pageNo, pageSize);
        PageHelper.orderBy("create_time desc");
        List<Member> list = memberMapper.findByPageForFront(keyWord);
        return new PageInfo<>(list);
    }

    @Override
    public List<Member> findByConditions() {
        return memberMapper.findByConditions();
    }

    @Override
    public Integer add(Member member) {
        String memberUuid = UUID.randomUUID().toString().replaceAll("-", "").substring(12);
        member.setMemberUuid(memberUuid);
        member.setMemberStatus(0);
        if (member.getMemberImgUrl() == null) {
            member.setMemberImgUrl("http://localhost/upload/index.png");
        }
        if (member.getMemberNickname() == null) {
            member.setMemberNickname("会员" + new Random().nextInt(9) + System.currentTimeMillis());
        }
        return memberMapper.insertSelective(member);
    }

    @Override
    public void delete(List<Integer> indexList) {
        indexList.forEach(index->{
            memberMapper.deleteByPrimaryKey(index);
        });
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", "").substring(12));
    }
}
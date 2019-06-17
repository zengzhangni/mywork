package com.aliyun.cs.controller;

import com.aliyun.cs.model.Member;
import com.aliyun.cs.service.MemberService;
import com.aliyun.cs.utils.base.ResponseMessage;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zengzhangni
 * @date 2019/3/6
 */
@Api(tags = "会员表")
@RestController
@RequestMapping(value = "member")
public class MemberController {


    @Resource
    private MemberService memberService;

    /**
     * 会员列表查询
     *
     * @param pageNo   分页索引
     * @param pageSize 分页数量
     * @param member   分页参数
     * @return 查询数据
     */
    @ApiOperation(value = "会员列表查询")
    @PostMapping("/findByPage")
    public ResponseMessage<PageInfo<Member>> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                @RequestBody Member member) {
        return this.memberService.findByPageForFront(pageNo, pageSize, member);
    }

    @ApiOperation(value = "会员列表查询")
    @GetMapping("/pageList")
    public List<Member> pageList(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return this.memberService.findByPageForFront(pageNo, pageSize, new Member()).getData().getList();
    }

    /**
     * 添加美容邦用户表
     *
     * @param member 会员数据
     * @return 是否成功添加
     */
    @ApiOperation(value = "添加美容邦用户表")
    @PostMapping("/insert")
    public ResponseMessage<Integer> insert(@RequestBody Member member) {
        return new ResponseMessage<>(this.memberService.addObj(member));
    }
}

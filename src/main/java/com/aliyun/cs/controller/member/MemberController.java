package com.aliyun.cs.controller.member;

import com.aliyun.cs.model.Member;

import com.aliyun.cs.service.MemberService;
import com.aliyun.cs.utils.base.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
@Api(tags = "会员表")
@RestController
@RequestMapping("member")
public class MemberController {

    @Resource
    private MemberService memberService;

    /**
     * 添加会员表
     */
    @ApiOperation(value = "添加会员表")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody Member member) {
        return new ResponseMessage<>(this.memberService.addObj(member));
    }

    @ApiOperation(value = "添加会员表")
    @PostMapping("/add")
    public ResponseMessage add(@RequestBody Member member) {
        return new ResponseMessage<>(this.memberService.add(member));
    }

    /**
     * 修改会员表
     */
    @ApiOperation(value = "修改会员表")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody Member member) {
        return new ResponseMessage<>(this.memberService.modifyObj(member));
    }
    /**
     * 删除会员表
     */
    @ApiOperation(value = "删除会员表")
    @PostMapping("/delete")
    public ResponseMessage delete(@RequestBody List<Integer> indexList) {
        this.memberService.delete(indexList);
        return new ResponseMessage<>();
    }

    @ApiOperation(value = "分页")
    @PostMapping("/findByPage")
    public ResponseMessage findByPageForFront(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(value = "keyWord", required = false) String keyWord) {
        return new ResponseMessage<>(this.memberService.findByPageForFront(pageNo, pageSize, keyWord));
    }
}
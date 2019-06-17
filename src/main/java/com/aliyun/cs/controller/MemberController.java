package com.aliyun.cs.controller;

import com.aliyun.cs.config.redis.RedisService;
import com.aliyun.cs.model.Member;
import com.aliyun.cs.service.MemberService;
import com.aliyun.cs.util.ResponseMessage;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zengzhangni
 * @date 2019/3/6
 */
@Api(tags = "美容邦用户表")
@RestController
@RequestMapping(value = "member")
public class MemberController {

    private static Map<String, String> yzmMap = new HashMap<>();


    @Resource
    private MemberService memberService;

    @PostMapping("/yzm")
    public ResponseMessage<String> yzm(@RequestParam String phone) {
        String random = RandomStringUtils.randomNumeric(4);
        yzmMap.put(phone, random);
        System.out.println(yzmMap);
        return new ResponseMessage<>(random);
    }

    @PostMapping("/register")
    public ResponseMessage<String> register(@RequestBody(required = false) Map map) {
        System.out.println(map);
        String phone = map.get("name").toString();
        String yzm = map.get("yzm").toString();
        String str = yzmMap.get(phone);
        System.out.println(str);
        if (StringUtils.isNotBlank(str)) {
            if (yzm.equals(str)) {
                return new ResponseMessage<>("验证码正确");
            } else {
                return new ResponseMessage<>("验证码错误");
            }
        }
        return new ResponseMessage<>("未知错误");
    }


    @PostMapping("/login")
    public ResponseMessage<Member> login(@RequestBody(required = false) Map map) {
        System.out.println(map);
        Member member = new Member();
        member.setId(1);
        member.setPlatformCode("add");
        member.setMemberName("小邦举147");
        member.setMemberNickname("小邦举147");
        member.setMemberUuid("147258369");
        member.setRegisterPhone("147258369");
        member.setGender((byte) 0);
        return new ResponseMessage<>(member);
    }

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

package com.aliyun.cs.controller;

import com.aliyun.cs.model.User;
import com.aliyun.cs.service.UserService;
import com.aliyun.cs.utils.base.ResponseMessage;
import com.aliyun.cs.utils.common.UUID;
import com.aliyun.cs.vo.user.RegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author liyang
 * @version 1.0 2019年6月17日
 */
@Api(tags = "用户")
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;



    /**
     * 添加
     */
    @ApiOperation(value = "添加")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody User user) {
        return new ResponseMessage<>(this.userService.addObj(user));
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody User user) {
        return new ResponseMessage<>(this.userService.modifyObj(user));
    }

    /**
     * 修改
     */
    @ApiOperation(value = "删除")
    @PutMapping("/del")
    public ResponseMessage del() {
        return new ResponseMessage<>(this.userService.deleteObjById(1));
    }


    @GetMapping("/yzm/{phone}")
    public ResponseMessage<String> yzm(@PathVariable(value = "phone") String phone) {
        return this.userService.getYzm(phone);
    }

    @PostMapping("/login")
    public ResponseMessage<User> login(@RequestBody RegisterVo registerVo) {
        return this.userService.login(registerVo);
    }
    @PostMapping("/register")
    public ResponseMessage<User> register(@RequestBody RegisterVo registerVo) {
        return this.userService.register(registerVo);
    }

}
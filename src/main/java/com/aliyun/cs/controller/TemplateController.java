package com.aliyun.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zengzhangni
 * @date 2019/6/14
 */
@Controller
public class TemplateController {


    @GetMapping("login")
    public String loginHtml() {
        return "login";
    }

    @GetMapping("register")
    public String registerHtml() {
        return "register";
    }

    @GetMapping("index")
    public String indexHtml() {
        return "index";
    }


}

package com.aliyun.cs.controller.menu;

import com.aliyun.cs.model.Menu;
import com.aliyun.cs.service.MenuService;
import com.aliyun.cs.utils.base.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyang
 * @version 1.0 2019年6月17日
 */
@Api(tags = "菜单")
@RestController
@RequestMapping("menu")
public class MenuController {

    @Resource
    private MenuService menuService;


    @ApiOperation(value = "菜单树")
    @GetMapping(value = "/getTree")
    public ResponseMessage<List<Menu>> getTree() {
        return new ResponseMessage<>(menuService.getTree());
    }









}
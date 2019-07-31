package com.aliyun.cs.controller.product;

import com.aliyun.cs.model.Product;

import com.aliyun.cs.service.ProductService;
import com.aliyun.cs.utils.base.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
@Api(tags = "项目(商品)基本信息")
@RestController
@RequestMapping("product")
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * 添加项目(商品)基本信息
     */
    @ApiOperation(value = "添加项目(商品)基本信息")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody Product product) {
        return new ResponseMessage<>(this.productService.addObj(product));
    }

    /**
     * 修改项目(商品)基本信息
     */
    @ApiOperation(value = "修改项目(商品)基本信息")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody Product product) {
        return new ResponseMessage<>(this.productService.modifyObj(product));
    }

    @ApiOperation(value = "分页")
    @PutMapping("/findByPage")
    public ResponseMessage findByPageForFront(@RequestParam Integer pageNo, @RequestParam Integer pageSize, @RequestBody Product product) {
        return new ResponseMessage<>(this.productService.findByPageForFront(pageNo, pageSize, product));
    }


}
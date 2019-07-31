package com.aliyun.cs.controller.recommend;

import com.aliyun.cs.model.Product;
import com.aliyun.cs.service.RecommendService;
import com.aliyun.cs.utils.base.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zengzhangni
 * @date 2019/7/22
 */
@Api(tags = "推荐")
@RestController
@RequestMapping("recommend")
public class RecommendController {


    @Resource
    private RecommendService recommendService;


    @ApiOperation(value = "获取推荐列表")
    @GetMapping("/get/{memberUuid}")
    public ResponseMessage insert(@PathVariable("memberUuid") String memberUuid) {
        return new ResponseMessage<>(recommendService.getRecommend(memberUuid));
    }


}

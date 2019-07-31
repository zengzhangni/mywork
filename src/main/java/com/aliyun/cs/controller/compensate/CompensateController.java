package com.aliyun.cs.controller.compensate;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.cs.mapper.CompensateMapper;
import com.aliyun.cs.model.Compensate;
import com.aliyun.cs.model.Member;
import com.aliyun.cs.model.Order;
import com.aliyun.cs.service.MemberService;
import com.aliyun.cs.service.OrderService;
import com.aliyun.cs.utils.base.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

/**
 * @author zengzhangni
 * @date 2019/7/30
 */
@Api(tags = "测试补偿")
@RestController
@RequestMapping("compensate")
public class CompensateController {


    @Resource
    private OrderService orderService;

    @ApiOperation(value = "添加订单表")
    @PostMapping("/add")
    public ResponseMessage add(@RequestBody Order order, @RequestParam Integer cs) {
        return this.orderService.addOrder(order, cs);
    }
    @ApiOperation(value = "添加订单表2")
    @PostMapping("/add2")
    public ResponseMessage add2(@RequestBody Order order, @RequestParam Integer cs) {
        return this.orderService.addOrder2(order, cs,"补偿测试",true,new Date());
    }





    @ApiOperation(value = "测试补偿2")
    @PostMapping("/cs2")
    public void cs2() {

    }


}

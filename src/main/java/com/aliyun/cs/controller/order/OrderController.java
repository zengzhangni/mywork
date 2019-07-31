package com.aliyun.cs.controller.order;

import com.aliyun.cs.model.Order;

import com.aliyun.cs.model.Product;
import com.aliyun.cs.service.OrderService;
import com.aliyun.cs.utils.base.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.klock.annotation.Klock;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
@Api(tags = "订单表")
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 添加订单表
     */
    @ApiOperation(value = "cs")
    @PostMapping("/cs")
    public ResponseMessage cs() {
        for (int i = 0; i < 20; i++) {
            String s = i + "";
            new Thread(() -> {
                try {
                    getValue(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }


        return new ResponseMessage<>();
    }

    @Klock(keys = {"#param"})
    public String getValue(String param) throws Exception {
        System.out.println("线程" + param);
        Thread.sleep(1000 * 5);
        System.out.println("线程2" + param);
        return "success";
    }

    /**
     * 添加订单表
     */
    @ApiOperation(value = "添加订单表")
    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody Order order) {
        return new ResponseMessage<>(this.orderService.addObj(order));
    }

    /**
     * 修改订单表
     */
    @ApiOperation(value = "修改订单表")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody Order order) {
        return new ResponseMessage<>(this.orderService.modifyObj(order));
    }

    @ApiOperation(value = "分页")
    @PutMapping("/findByPage")
    public ResponseMessage findByPageForFront(@RequestParam Integer pageNo, @RequestParam Integer pageSize, @RequestBody Order order) {
        return new ResponseMessage<>(this.orderService.findByPageForFront(pageNo, pageSize, order));
    }
}
package com.aliyun.cs.service.impl;

import javax.annotation.Resource;

import com.aliyun.cs.mapper.OrderMapper;
import com.aliyun.cs.service.OrderService;
import com.aliyun.cs.utils.aop.Compensate;
import com.aliyun.cs.utils.base.BaseServiceImpl;
import com.aliyun.cs.utils.base.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aliyun.cs.model.Order;

import java.util.Date;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {


    @Resource
    private OrderMapper orderMapper;

    @Override
    @Compensate
    public ResponseMessage addOrder(Order order, Integer cs) {
        System.out.println(cs);
//        System.out.println(1 / 0);
        return new ResponseMessage<>();
    }

    @Override
    @Compensate
    public ResponseMessage addOrder2(Order order, Integer cs, String str, Boolean b, Date date) {
        System.out.println(cs);
        System.out.println(str);
        System.out.println(b);
        System.out.println(date);
        System.out.println(1 / 0);
        return new ResponseMessage<>();
    }

}
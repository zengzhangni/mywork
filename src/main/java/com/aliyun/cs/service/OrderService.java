package com.aliyun.cs.service;


import com.aliyun.cs.model.Order;
import com.aliyun.cs.utils.base.BaseService;
import com.aliyun.cs.utils.base.ResponseMessage;

import java.util.Date;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
public interface OrderService extends BaseService<Order> {

    ResponseMessage addOrder(Order order,Integer cs);

    ResponseMessage addOrder2(Order order, Integer cs, String str, Boolean b, Date date);
}
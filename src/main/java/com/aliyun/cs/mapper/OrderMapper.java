package com.aliyun.cs.mapper;

import com.aliyun.cs.model.Order;
import com.aliyun.cs.utils.base.BaseMapper;

import java.util.List;
import java.util.Set;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
public interface OrderMapper extends BaseMapper<Order> {

    List<Integer> queryByMemberUuid(String memberUuid);

    Integer addOrder(Order order);

}
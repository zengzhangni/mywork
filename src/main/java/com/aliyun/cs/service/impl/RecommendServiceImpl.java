package com.aliyun.cs.service.impl;

import com.aliyun.cs.mapper.OrderMapper;
import com.aliyun.cs.mapper.ProductMapper;
import com.aliyun.cs.mapper.RecommendMapper;
import com.aliyun.cs.mapper.TraceMapper;
import com.aliyun.cs.model.Product;
import com.aliyun.cs.model.Recommend;
import com.aliyun.cs.model.Trace;
import com.aliyun.cs.service.RecommendService;
import com.aliyun.cs.utils.base.BaseServiceImpl;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author zengzhangni
 * @date 2019/7/22
 */
@Service
public class RecommendServiceImpl extends BaseServiceImpl<Recommend> implements RecommendService {

    @Resource
    private RecommendMapper recommendMapper;
    @Resource
    private ProductMapper productMapper;
    @Resource
    private TraceMapper traceMapper;
    @Resource
    private OrderMapper orderMapper;


    @Override
    public List getRecommend(String memberUuid) {

        //足迹商品id集合
        List<Integer> list = traceMapper.getByMemberUuid(memberUuid);
        //足迹标签集合
        List<String> tagList = productMapper.queryTagByProductIdList(list);
        //订单商品id 1 5
        List<Integer> oList = orderMapper.queryByMemberUuid(memberUuid);
        //订单标签集合
        List<String> tagList2 = productMapper.queryTagByProductIdList(oList);
        //获取用户所有标签
        tagList2.addAll(tagList);
        //通过标签和过滤已买商品 得到推荐商品id集合
        Set<Integer> ids = productMapper.getIdList(oList, tagList2);
        //通过id集合查询商品信息
        List<Product> productList = productMapper.queryByProductIdList(ids);
        return productList;
    }


}

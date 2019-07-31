package com.aliyun.cs.service.impl;

import javax.annotation.Resource;

import com.aliyun.cs.mapper.ProductMapper;
import com.aliyun.cs.service.ProductService;
import com.aliyun.cs.utils.base.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aliyun.cs.model.Product;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {


    @Resource
    private ProductMapper productMapper;
}
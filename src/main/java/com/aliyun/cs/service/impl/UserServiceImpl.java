package com.aliyun.cs.service.impl;


import com.aliyun.cs.config.redis.RedisService;
import com.aliyun.cs.mapper.UserMapper;
import com.aliyun.cs.model.User;
import com.aliyun.cs.service.UserService;
import com.aliyun.cs.utils.base.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author liyang
 * @version 1.0 2019年6月17日
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {


    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisService redisService;
}
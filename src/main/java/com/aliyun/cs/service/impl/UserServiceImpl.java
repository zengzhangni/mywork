package com.aliyun.cs.service.impl;


import com.aliyun.cs.mapper.UserMapper;
import com.aliyun.cs.model.User;
import com.aliyun.cs.service.UserService;
import com.aliyun.cs.util.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author liyang
 * @version 1.0 2019年6月17日
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;
}
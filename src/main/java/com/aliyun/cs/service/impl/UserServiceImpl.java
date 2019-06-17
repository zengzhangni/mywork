package com.aliyun.cs.service.impl;

import java.util.Date;


import com.aliyun.cs.config.redis.RedisService;
import com.aliyun.cs.mapper.UserMapper;
import com.aliyun.cs.model.User;
import com.aliyun.cs.service.UserService;
import com.aliyun.cs.utils.base.BaseServiceImpl;
import com.aliyun.cs.utils.base.ResponseMessage;
import com.aliyun.cs.utils.common.UUID;
import com.aliyun.cs.vo.user.RegisterVo;
import org.apache.commons.lang.RandomStringUtils;
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
    @Resource
    private RedisService redisService;

    @Override
    public ResponseMessage<User> register(RegisterVo registerVo) {
        String userPhone = registerVo.getUserPhone();
        String str = redisService.getStr(userPhone);
        String yzm = registerVo.getYzm();
        if (!yzm.equals(str)) {
            return new ResponseMessage<>(500, "验证码错误");
        }
        User user = new User();
        user.setUserUuid(new UUID().getUuid());
        user.setUserPhone(userPhone);
        user.setUserPassword(registerVo.getUserPassword());
        userMapper.insertSelective(user);
        return new ResponseMessage<>(user);
    }

    @Override
    public ResponseMessage<User> login(RegisterVo registerVo) {
        String userPhone = registerVo.getUserPhone();
        String userPassword = registerVo.getUserPassword();
        User user = userMapper.queryByPhoneAndPwd(userPhone, userPassword);
        if (user == null) {
            return new ResponseMessage<>(500, "用户不存在或账号密码错误");
        }
        return new ResponseMessage<>(user);
    }

    @Override
    public ResponseMessage<String> getYzm(String phone) {
        String random = RandomStringUtils.randomNumeric(4);
        redisService.setStr(phone, random, 300L);
        return new ResponseMessage<>(random);
    }
}
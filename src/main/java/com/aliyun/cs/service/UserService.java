package com.aliyun.cs.service;


import com.aliyun.cs.model.User;
import com.aliyun.cs.utils.base.ResponseMessage;
import com.aliyun.cs.utils.base.SpringCloudBaseService;
import com.aliyun.cs.vo.user.RegisterVo;

/**
 * @author liyang
 * @version 1.0 2019年6月17日
 */
public interface UserService extends SpringCloudBaseService<User> {

    ResponseMessage<User> register(RegisterVo registerVo);
    ResponseMessage<User> login(RegisterVo registerVo);

    ResponseMessage<String> getYzm(String phone);

}
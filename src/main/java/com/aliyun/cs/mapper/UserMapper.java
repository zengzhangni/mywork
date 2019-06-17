package com.aliyun.cs.mapper;


import com.aliyun.cs.model.User;
import com.aliyun.cs.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author liyang
 * @version 1.0 2019年6月17日
 */
public interface UserMapper extends BaseMapper<User> {

    User queryByPhoneAndPwd(@Param("userPhone") String userPhone, @Param("userPassword") String userPassword);

}
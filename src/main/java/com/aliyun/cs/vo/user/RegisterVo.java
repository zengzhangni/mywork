package com.aliyun.cs.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zengzhangni
 * @date 2019/6/17
 */
@Data
@ApiModel(value = "User注册条件")
public class RegisterVo {

    @ApiModelProperty("用户手机号")
    private String userPhone;
    @ApiModelProperty("用户密码")
    private String userPassword;
    @ApiModelProperty("验证码")
    private String yzm;

}

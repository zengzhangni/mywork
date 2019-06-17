package com.aliyun.cs.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zengzhangni
 * @version 1.0 2019年6月17日
 */
@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "用户")
public class User implements Serializable {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("用户uuid")
    private String userUuid;
    @ApiModelProperty("用户姓名")
    private String userName;
    @ApiModelProperty("用户手机号")
    private String userPhone;
    @ApiModelProperty("用户密码")
    private String userPassword;
    @ApiModelProperty("用户头像")
    private String userImg;
    @ApiModelProperty("用户年龄")
    private Integer userAge;
    @ApiModelProperty("用户生日")
    private Date userBirthday;
}
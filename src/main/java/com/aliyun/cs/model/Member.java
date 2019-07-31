package com.aliyun.cs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
@Data
@ApiModel(value = "会员表")
public class Member implements Serializable {

    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("会员昵称")
    private String memberNickname;
    @ApiModelProperty("会员uuid")
    private String memberUuid;
    @ApiModelProperty("注册账号")
    private String loginName;
    @ApiModelProperty("密码")
    private String loginPassword;
    @ApiModelProperty("注册手机号")
    private String registerPhone;
    @ApiModelProperty("性别（0：男，1：女）")
    private Integer gender;
    @ApiModelProperty("会员头像")
    private String memberImgUrl;
    @ApiModelProperty("个人签名")
    private String personSignature;
    @ApiModelProperty("出生年月")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date birthday;
    @ApiModelProperty("账号状态，0:正常 1:禁用")
    private Integer memberStatus;
    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Byte isEnabled;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;

}
package com.aliyun.cs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liyang
 * @version 1.0 2019年3月5日
 */
@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "会员表")
public class Member implements Serializable {

    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("平台编码")
    private String platformCode;
    @ApiModelProperty("会员姓名")
    private String memberName;
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
    private Byte gender;
    @ApiModelProperty("会员头像")
    private String memberImgUrl;
    @ApiModelProperty("个人签名")
    private String personSignature;
    @ApiModelProperty("出生年月")
    private Date birthday;
    @ApiModelProperty("等级")
    private String memberLevel;
    @ApiModelProperty("用户类型，1:C端用户，2:B端店长，3:B端店员")
    private Integer memberType;
    @ApiModelProperty("认证状态，1:待认证 2:已通过 3:未通过")
    private Integer authStatus;
    @ApiModelProperty("账号状态，0:正常 1:禁用")
    private Integer memberStatus;
    @ApiModelProperty("来源 1:门店公众号 2:门店APP 3:门店后台 4:美容邦公众号")
    private Integer memberOrigin;
    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Byte isEnabled;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

}
package com.aliyun.cs.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月16日
 */
@Data
@ApiModel(value = "订单表")
public class Order implements Serializable {

    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("订单号")
    private String orderNo;
    @ApiModelProperty("会员编码")
    private String memberUuid;
    @ApiModelProperty("会员编码")
    private String productId;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;

}
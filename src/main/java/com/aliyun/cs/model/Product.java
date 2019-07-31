package com.aliyun.cs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@ApiModel(value = "项目(商品)基本信息")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Serializable {

    @ApiModelProperty("商品ID")
    private Integer id;
    @ApiModelProperty("商户商品编码")
    private String productName;
    @ApiModelProperty("标签")
    private String tag;
    @ApiModelProperty("软删除标记，1为正常，0为删除")
    private Integer isEnabled;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;

}
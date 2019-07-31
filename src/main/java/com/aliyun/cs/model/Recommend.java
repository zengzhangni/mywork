package com.aliyun.cs.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author zengzhangni
 * @date 2019/7/22
 */
@Data
@ApiModel(value = "推荐")
public class Recommend {

    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("会员编码")
    private String memberUuid;
    @ApiModelProperty("商品id集合")
    private String productIdList;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;

}

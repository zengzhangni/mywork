package com.aliyun.cs.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zengzhangni
 * @date 2019/7/31
 */
@Data
@ApiModel(value = "活动表")
public class Activity implements Serializable {

    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("活动编号")
    private String activityNo;
    @ApiModelProperty("活动名称")
    private String activityName;
    @ApiModelProperty("开始时间")
    private Date beginTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("是否终止 0:是 1:正常")
    private Integer isTermination;
    //可能还要什么 活动类型  是否删除 其他字段

}

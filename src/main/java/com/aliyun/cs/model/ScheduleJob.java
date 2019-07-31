package com.aliyun.cs.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zengzhangni
 * @date 2019/7/29
 */
@Data
@ApiModel(value = "定时任务表")
public class ScheduleJob implements Serializable {

    /**
     * 暂停
     */
    public static final Integer JOB_STATE_PAUSE = 0;
    /**
     * 正常
     */
    public static final Integer JOB_STATE_NORMAL = 1;

    @ApiModelProperty("定时任务Id")
    private Integer id;
    @ApiModelProperty("定时任务名称")
    private String jobName;
    @ApiModelProperty("job唯一代码")
    private String jobCode;
    @ApiModelProperty("job描述")
    private String description;
    @ApiModelProperty("定时任务完整类名称")
    private String jobClass;
    @ApiModelProperty("定时任务方法名称")
    private String jobMethod;
    @ApiModelProperty("job状态,1-正常运行，0-暂停")
    private Integer jobState;
    @ApiModelProperty("定时任务的Corn表达式")
    private String cron;
    @ApiModelProperty("是否启用，1启用，0禁用")
    private Integer isEnable;
    @ApiModelProperty("能否并发运行，1可以，0不可以")
    private Integer isConcurrent;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}

package com.aliyun.cs.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zengzhangni
 * @date 2019/7/30
 */
@Data
@ApiModel(value = "补偿任务表")
public class Compensate implements Serializable {

    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("补偿编码")
    private String compensateNo;

    @ApiModelProperty("补偿参数")
    private String compensateArgs;
    @ApiModelProperty("补偿参数类型")
    private String compensateArgsType;

    @ApiModelProperty("补偿类名")
    private String className;
    @ApiModelProperty("补偿方法名")
    private String methodName;

    @ApiModelProperty("补偿状态 0:需要 1:不需要")
    private Integer compensateState;
    @ApiModelProperty("错误信息")
    private String errMsg;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
}

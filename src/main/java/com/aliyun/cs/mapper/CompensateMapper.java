package com.aliyun.cs.mapper;

import com.aliyun.cs.model.Compensate;
import com.aliyun.cs.utils.base.BaseMapper;

import java.util.List;

/**
 * @author zengzhangni
 * @version 1.0 2019年7月30日
 */
public interface CompensateMapper extends BaseMapper<Compensate> {

    List<Compensate> getAll();

    /**
     * 获取所有需要补偿的
     *
     * @return
     */
    List<Compensate> getAllWantCompensate();

    Integer updateByCompensateNo(Compensate compensate);


    Compensate queryByCompensateNo(String compensateNo);

}
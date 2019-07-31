package com.aliyun.cs.service;

import com.aliyun.cs.model.Compensate;
import com.aliyun.cs.utils.base.BaseService;

import java.util.List;

/**
 * @author zengzhangni
 * @date 2019/7/30
 */
public interface CompensateService extends BaseService<Compensate> {

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

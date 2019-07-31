package com.aliyun.cs.service.impl;

import com.aliyun.cs.mapper.CompensateMapper;
import com.aliyun.cs.model.Compensate;
import com.aliyun.cs.service.CompensateService;
import com.aliyun.cs.utils.base.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zengzhangni
 * @date 2019/7/30
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class CompensateServiceImpl extends BaseServiceImpl<Compensate> implements CompensateService {


    @Resource
    private CompensateMapper compensateMapper;


    @Override
    public List<Compensate> getAll() {
        return compensateMapper.getAll();
    }

    @Override
    public List<Compensate> getAllWantCompensate() {
        return compensateMapper.getAllWantCompensate();
    }

    @Override
    public Integer updateByCompensateNo(Compensate compensate) {
        return compensateMapper.updateByCompensateNo(compensate);
    }

    @Override
    public Compensate queryByCompensateNo(String compensateNo) {
        return compensateMapper.queryByCompensateNo(compensateNo);
    }

}

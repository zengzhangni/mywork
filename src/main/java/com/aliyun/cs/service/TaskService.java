package com.aliyun.cs.service;

import com.aliyun.cs.model.ScheduleJob;
import com.github.pagehelper.PageInfo;

/**
 * @author zengzhangni
 * @date 2019/7/29
 */
public interface TaskService {

    PageInfo<ScheduleJob> findByPage(Integer pageNo, Integer pageSize);

    int saveJob(ScheduleJob entity);

    int update(ScheduleJob entity);

    int delete(String jobClass);

    int pause(String jobClass);

    int resume(String jobClass);

    ScheduleJob detail(Integer id);

}

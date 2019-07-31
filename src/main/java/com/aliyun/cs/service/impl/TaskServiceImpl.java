package com.aliyun.cs.service.impl;

import com.aliyun.cs.mapper.ScheduleJobMapper;
import com.aliyun.cs.model.ScheduleJob;
import com.aliyun.cs.service.TaskService;
import com.aliyun.cs.utils.job.SchedulerUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * @author zengzhangni
 * @date 2019/7/29
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TaskServiceImpl implements TaskService {


    @Autowired
    private Scheduler scheduler;

    @Autowired
    private ScheduleJobMapper scheduleJobMapper;

    @PostConstruct
    public void init() {
        List<ScheduleJob> jobList = scheduleJobMapper.selectAll();
        if (!CollectionUtils.isEmpty(jobList)) {
            for (ScheduleJob job : jobList) {
                SchedulerUtil.createScheduleJob(scheduler, job);
            }
        }

    }


    /**
     * 查询列表
     *
     * @return
     */
    @Override
    public PageInfo<ScheduleJob> findByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<ScheduleJob> list = scheduleJobMapper.selectAll();

        return new PageInfo<>(list);
    }


    /**
     * 保存
     *
     * @param job
     */
    @Override
    public int saveJob(ScheduleJob job) {
        job.setCreateTime(new Date());
        int i = scheduleJobMapper.insertSelective(job);
        SchedulerUtil.createScheduleJob(scheduler, job);
        return i;
    }

    /**
     * 更新
     *
     * @param job
     */
    @Override
    public int update(ScheduleJob job) {
        int i = scheduleJobMapper.updateByPrimaryKeySelective(job);
        SchedulerUtil.updateScheduleJob(scheduler, job);
        return i;
    }

    /**
     * 删除
     *
     * @param jobClass
     */
    @Override
    public int delete(String jobClass) {
        int i = scheduleJobMapper.deleteByJobClass(jobClass);
        SchedulerUtil.deleteScheduleJob(scheduler, jobClass);
        return i;
    }

    /**
     * 暂停
     *
     * @param jobClass
     */
    @Override
    public int pause(String jobClass) {
        int i = scheduleJobMapper.updateJobState(jobClass, ScheduleJob.JOB_STATE_PAUSE);
        SchedulerUtil.pauseJob(scheduler, jobClass);
        return i;
    }

    /**
     * 恢复
     *
     * @param jobClass
     */
    @Override
    public int resume(String jobClass) {
        int i = scheduleJobMapper.updateJobState(jobClass, ScheduleJob.JOB_STATE_NORMAL);
        SchedulerUtil.resumeJob(scheduler, jobClass);
        return i;
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public ScheduleJob detail(Integer id) {
        return scheduleJobMapper.selectByPrimaryKey(id);
    }
}

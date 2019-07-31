package com.aliyun.cs.mapper;

import com.aliyun.cs.model.ScheduleJob;
import com.aliyun.cs.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liufeihua
 */
@Mapper
public interface ScheduleJobMapper extends BaseMapper<ScheduleJob> {


    /**
     * 查询所有
     * @return
     */
    List<ScheduleJob> selectAll();

    /**
     * 更改任务状态
     * @param jobClass
     * @param jobState
     * @return
     */
    int updateJobState(@Param("jobClass") String jobClass, @Param("jobState") Integer jobState);

    /**
     * 根据 jobClass 删除
     * @param jobClass
     * @return
     */
    int deleteByJobClass(String jobClass);
}
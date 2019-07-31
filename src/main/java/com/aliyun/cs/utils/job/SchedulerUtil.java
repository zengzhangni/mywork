package com.aliyun.cs.utils.job;


import com.aliyun.cs.model.ScheduleJob;
import org.quartz.*;

/**
 * @Author: pkl
 * @Date: 2019/5/23 18:22
 */
public class SchedulerUtil {

    /**
     * 获取触发器key
     */
    public static TriggerKey getTriggerKey(String jobClass) {
        return TriggerKey.triggerKey(jobClass);
    }

    /**
     * 获取jobKey
     */
    public static JobKey getJobKey(String jobClass) {
        return JobKey.jobKey(jobClass);
    }

    /**
     * 获取表达式触发器
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, String jobClass) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(jobClass));
        } catch (SchedulerException e) {
            throw new RuntimeException("获取定时任务CronTrigger出现异常");
        }
    }

    /**
     * 创建定时任务
     */
    public static void createScheduleJob(Scheduler scheduler, ScheduleJob job) {
        try {

            Class clazz = Class.forName(job.getJobClass());
            //构建job信息
            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(getJobKey(job.getJobClass())).withDescription(job.getDescription()).build();

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCron())
                    .withMisfireHandlingInstructionDoNothing();

            //按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(job.getJobClass())).withSchedule(scheduleBuilder).build();


            scheduler.scheduleJob(jobDetail, trigger);

            //暂停任务
            if (job.getJobState() != null && job.getJobState().equals(ScheduleJob.JOB_STATE_PAUSE)) {
                pauseJob(scheduler, job.getJobClass());
            }
        } catch (Exception e) {

        }
    }

    /**
     * 更新定时任务
     */
    public static void updateScheduleJob(Scheduler scheduler, ScheduleJob job) {
        try {
            TriggerKey triggerKey = getTriggerKey(job.getJobClass());

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCron())
                    .withMisfireHandlingInstructionDoNothing();


            CronTrigger trigger = getCronTrigger(scheduler, job.getJobClass());

            //按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            scheduler.rescheduleJob(triggerKey, trigger);
            //暂停任务
            if (job.getJobState() != null && job.getJobState() == ScheduleJob.JOB_STATE_PAUSE) {
                pauseJob(scheduler, job.getJobClass());
            }

        } catch (SchedulerException e) {

        }
    }


    /**
     * 暂停任务
     */
    public static void pauseJob(Scheduler scheduler, String jobClass) {
        try {
            scheduler.pauseJob(getJobKey(jobClass));
            System.out.println(jobClass + ":任务暂停");
        } catch (SchedulerException e) {

        }
    }

    /**
     * 恢复任务
     */
    public static void resumeJob(Scheduler scheduler, String jobClass) {
        try {
            scheduler.resumeJob(getJobKey(jobClass));
            System.out.println(jobClass + ":任务恢复");
        } catch (SchedulerException e) {

        }
    }

    /**
     * 删除定时任务
     */
    public static void deleteScheduleJob(Scheduler scheduler, String jobClass) {
        try {
            scheduler.deleteJob(getJobKey(jobClass));
            System.out.println(jobClass + ":任务删除");
        } catch (SchedulerException e) {

        }
    }

    /**
     * 获取jobDetail
     *
     * @param jobKey
     * @return
     */
    public static JobDetail getJobDetail(Scheduler scheduler, JobKey jobKey) {
        try {
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            return jobDetail;
        } catch (SchedulerException e) {
            return null;
        }
    }
}

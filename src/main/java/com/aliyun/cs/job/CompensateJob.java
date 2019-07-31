package com.aliyun.cs.job;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.cs.mapper.CompensateMapper;
import com.aliyun.cs.model.Compensate;
import com.aliyun.cs.utils.base.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zengzhangni
 * @date 2019/7/30
 */
@Slf4j
public class CompensateJob extends QuartzJobBean {

    public static void main(String[] args) {
        Object i = 1;
        Integer integer = JSONObject.parseObject(i.toString(), Integer.TYPE);
        System.out.println(integer);
        Object s = new Date();
        Date s1 = JSONObject.parseObject(s.toString(), Date.class);
        System.out.println(s1);
    }
    private static Lock lock = new ReentrantLock(true);
    @Resource
    private CompensateMapper mapper;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        lock.lock();
        log.info("补偿任务开始执行....");
        try {
            List<Compensate> compensates = mapper.getAllWantCompensate();
            for (Compensate compensate : compensates) {
                try {
                    Instant currentTime = Instant.now();
                    Instant createTime = compensate.getCreateTime().toInstant();
                    if (ChronoUnit.SECONDS.between(createTime, currentTime) < 30) {
                        log.info("时间相差小于30s,暂不处理!");
                        continue;
                    }
                    //参数
                    String compensateArgs = compensate.getCompensateArgs();
                    Object[] args = JSONObject.parseObject(compensateArgs, Object[].class);
                    //参数类型
                    String compensateArgsType = compensate.getCompensateArgsType();
                    Class[] argsType = JSONObject.parseObject(compensateArgsType, Class[].class);
                    for (int i = 0; i < args.length; i++) {
                        //获取参数真实类型
                        if (args[i] instanceof String) {
                            continue;
                        }
                        args[i] = JSONObject.parseObject(args[i].toString(), argsType[i]);
                    }
                    //类名
                    String className = compensate.getClassName();
                    //方法名
                    String methodName = compensate.getMethodName();

                    //获取对应类
                    Class<?> executeClass = Class.forName(className);
                    //获取对应方法
                    Method methods = executeClass.getDeclaredMethod(methodName, argsType);
                    //执行方法
                    Object invoke = methods.invoke(executeClass.newInstance(), args);
                    if (invoke instanceof ResponseMessage) {
                        ResponseMessage response = (ResponseMessage) invoke;
                        if (response.getCode() == 200) {
                            compensate.setCompensateState(1);
                            mapper.updateByCompensateNo(compensate);
                            log.info("编号:{},补偿成功! 修改补偿状态为完成", compensate.getCompensateNo());
                        }
                    }
                } catch (Exception e) {
                    log.error("补偿任务异常! 补偿编码:{} , 补偿类:{},补偿方法:{},补偿参数:{}", compensate.getCompensateNo(), compensate.getClassName(), compensate.getMethodName(),compensate.getCompensateArgs());
                }
            }
        } finally {
            lock.unlock();
        }
        log.info("补偿任务执行结束....");
    }
}

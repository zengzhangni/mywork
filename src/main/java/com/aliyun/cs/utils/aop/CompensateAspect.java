package com.aliyun.cs.utils.aop;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.cs.exception.CompensateException;
import com.aliyun.cs.mapper.CompensateMapper;
import com.aliyun.cs.service.CompensateService;
import com.aliyun.cs.utils.base.ResponseMessage;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import com.aliyun.cs.model.Compensate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * @author zengzhangni
 * @date 2019/7/30
 */
@Component
@Aspect
@Slf4j
public class CompensateAspect {

    @Resource
    private CompensateService service;

    //Service层切点     用于记录错误日志
    @Pointcut("@annotation(com.aliyun.cs.utils.aop.Compensate)")
    public void compensateAspect() {

    }

    @Around("compensateAspect()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object obj;
        Compensate compensate = new Compensate();
        Object target = joinPoint.getTarget();
        String className = target.getClass().getName();
        System.out.println("类名:" + className);

        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("方法名" + methodName);

        String[] s = signature.toLongString().split(" ");
        String argsType = getArgsType(s[2]);
        System.out.println("参数类型:" + argsType);
        Object[] arg = joinPoint.getArgs();
        String param = JSONObject.toJSON(arg).toString();
        System.out.println("参数值:" + param);


        String compensateNo = UUID.randomUUID().toString();
        try {
            //补偿编码
            compensate.setCompensateNo(compensateNo);
            //参数
            compensate.setCompensateArgs(param);
            //参数类型
            compensate.setCompensateArgsType(argsType);
            //方法
            compensate.setMethodName(methodName);
            //类名
            compensate.setClassName(className);
            //需要补偿
            compensate.setCompensateState(0);
            //新增记录
            service.addObj(compensate);
            //进行执行
            obj = joinPoint.proceed();
            //获取返回值
            if (obj instanceof ResponseMessage) {
                ResponseMessage response = (ResponseMessage) obj;
                if (response.getCode() != 200) {
                    //记录错误信息
                    compensate.setErrMsg(response.getMessage());
                } else {
                    compensate.setCompensateState(1);
                    System.out.println("更新状态不需要补偿");
                }
            }
            //更新补偿记录
            service.updateByCompensateNo(compensate);
        } catch (Throwable e) {
            //错误信息
            Compensate compensate2 = service.queryByCompensateNo(compensate.getCompensateNo());
            System.out.println(e.getMessage());
            compensate.setErrMsg(e.getMessage());
            if (compensate2 != null) {
                service.updateByCompensateNo(compensate);
            } else {
                service.addObj(compensate);
            }
            return new ResponseMessage<>(500, "异常了!");
        }
        return obj;
    }


    /**
     * 得到方法参数的类型
     */
    private static String getArgsType(String str) {
        String substr = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        return JSONObject.toJSON(substr.split(",")).toString();
    }


}

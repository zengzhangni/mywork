package com.aliyun.cs.exception;

import com.aliyun.cs.utils.base.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zengzhangni
 * @date 2019/5/21
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 补偿异常
     */
    @ExceptionHandler(CompensateException.class)
    @ResponseBody
    public ResponseMessage handleException(CompensateException ex) {
        log.error("补偿异常:code:{},msg:{},data:{}", ex.getCode(), ex.getMessage(), ex.getData());
        return new ResponseMessage<>(ex.getCode(), ex.getMessage(), ex.getData());
    }

    /**
     * 空指针异常处理
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseMessage handleException(NullPointerException ex) {
        log.error("Member服务空指针异常!:errmsg:{}", ex.getStackTrace()[0]);
        return new ResponseMessage<>(120500, "空指针异常!", ex.getStackTrace()[0]);
    }

    /**
     * 类型转换异常处理
     */
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public ResponseMessage handleException(ClassCastException ex) {
        log.error("Member类型转换异常!:errmsg:{},err:{}", ex.getMessage(), ex.getStackTrace()[0]);
        return new ResponseMessage<>(120500, "类型转换异常!" + ex.getMessage(), ex.getStackTrace()[0]);
    }

}

package com.aliyun.cs.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zengzhangni
 * @date 2019/5/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompensateException extends RuntimeException {

    private Integer code = 170500;
    private String message;
    private Object data;


    public CompensateException(String message) {
        this.message = message;
    }

    public CompensateException(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}

package com.aliyun.cs;

/**
 * @author zengzhangni
 * @date 2019/6/13
 */

import com.didispace.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableSwagger2Doc
@SpringBootApplication
@ComponentScan("com.aliyun")
@MapperScan(basePackages = "com.aliyun.cs.mapper")
@EnableRabbit
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}

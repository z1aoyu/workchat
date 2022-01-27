package com.b1aoyu.workchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author：z1aoyu 2022-01-27
 * @description:企业微信ISV服务启动类
 */
@ComponentScan(basePackages = {"com.b1aoyu.workchat.**"})
@SpringBootApplication
public class WorkChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkChatApplication.class, args);
    }

}

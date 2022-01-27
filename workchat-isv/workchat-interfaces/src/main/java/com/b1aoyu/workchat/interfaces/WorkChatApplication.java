package com.b1aoyu.workchat.interfaces;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author：z1aoyu 2022-01-27
 * @description:企业微信ISV服务启动类
 */
@SpringBootApplication
@Configurable
public class WorkChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkChatApplication.class, args);
    }

}

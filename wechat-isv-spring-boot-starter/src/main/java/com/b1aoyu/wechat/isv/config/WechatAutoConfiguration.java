package com.b1aoyu.wechat.isv.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.b1aoyu.wechat.isv.service.corp.CorpService;
import com.b1aoyu.wechat.isv.service.corp.impower.CorpImpowerService;
import com.b1aoyu.wechat.isv.service.third.ThirdService;
import com.b1aoyu.wechat.isv.service.user.UserService;

/**
 * @author：z1aoyu 2022-01-26
 * @description:自动配置类
 */
@Configuration
@EnableConfigurationProperties(WechatProperties.class)
public class WechatAutoConfiguration {


    @Bean
    public UserService userBean() {
        return new UserService();
    }

    @Bean
    public ThirdService thirdBean() {
        return new ThirdService();
    }


    @Bean
    public CorpService corpBean() {
        return new CorpService();
    }


    @Bean
    public CorpImpowerService corpImpowerBean() {
        return new CorpImpowerService();
    }

}

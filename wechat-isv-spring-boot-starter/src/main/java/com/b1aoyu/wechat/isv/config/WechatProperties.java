package com.b1aoyu.wechat.isv.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-26
 * @description:读取配置文件信息
 */
@Data
@ConfigurationProperties(prefix = "wechat")
public class WechatProperties {

    //第三方企业Id
    private String corpId;

    //回调配置密令
    private String token;

    //回调配置密钥
    private String aesKey;

    //用户身份验证回调地址（身份验证接口）
    private String userOauthUrl;

    //企业回调地址（企业安装应用接口）
    private String corpOauthUrl;

}

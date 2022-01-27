package com.b1aoyu.wechat.isv.bean.dto.res.corp;

import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:推广二维码安装相关信息，扫推广二维码安装时返回。（注：无论企业是否新注册，只要通过扫推广二维码安装，都会返回该字段）
 */
@Data
public class RegisterCodeInfoResDto {

    /**
     * 注册码
     **/
    private String register_code;

    /**
     * 推广包ID
     **/
    private String template_id;

    /**
     * 仅当获取注册码指定该字段时才返回
     **/
    private String state;

}

package com.b1aoyu.wechat.isv.bean.dto.res;

import lombok.Data;

/**
 * @author z1aoyu 2022-01-06
 **/
@Data
public class AccessTokenResDto {
    /**
     * 错误码，0表示正常返回，可读取admin的管理员列表
     **/
    private String errcode;

    /**
     * 对返回码的文本描述内容
     **/
    private String errmsg;

    /**
     * 企业应用凭证
     **/
    private String access_token;

    /**
     * 凭证有效时间，单位：秒
     **/
    private String expires_in;

}

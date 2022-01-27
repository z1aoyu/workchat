package com.b1aoyu.wechat.isv.bean.dto.res;

import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description: 获取预授权码Dto
 */
@Data
public class PreAuthorizationResDto {

    /**
     * 错误码，0表示正常返回，可读取admin的管理员列表
     **/
    private String errcode;

    /**
     * 错误说明
     **/
    private String errmsg;

    /**
     * 预授权码,最长为512字节
     **/
    private String pre_auth_code;

    /**
     * 有效期（秒）
     **/
    private String expires_in;

}

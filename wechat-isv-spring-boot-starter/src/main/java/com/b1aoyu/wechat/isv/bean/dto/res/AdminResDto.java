package com.b1aoyu.wechat.isv.bean.dto.res;

import lombok.Data;

/**
 * @author z1aoyu 2022-01-06
 **/
@Data
public class AdminResDto {

    /**
     * 错误码，0表示正常返回，可读取admin的管理员列表
     **/
    private String errcode;

    /**
     * 	错误说明
     **/
    private String errmsg;

    /**
     * 应用的管理员列表（不包括外部管理员），成员授权模式下，不返回系统管理员
     **/
    private String admin;

    /**
     * 管理员的userid
     **/
    private String userid;

    /**
     * 管理员的open_userid
     **/
    private String open_userid;

    /**
     * 该管理员对应用的权限：0=发消息权限，1=管理权限
     **/
    private String auth_type;



}

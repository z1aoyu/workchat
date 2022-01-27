package com.b1aoyu.wechat.isv.bean.dto.res;

import lombok.Data;

/**
 * @author z1aoyu 2021-09-29
 **/
@Data
public class TicketDto {

    /**
     * 错误码
     **/
    private String errcode;

    /**
     * 错误信息
     **/
    private String errmsg;

    /**
     * ticket值
     **/
    private String ticket;

    /**
     * expires_in值
     **/
    private String expires_in;

}

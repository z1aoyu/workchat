package com.b1aoyu.workchat.application.beans.bo;

import lombok.Data;

/**
 * @author z1aoyu 2022-01-28
 *         应用安装订阅事件
 **/
@Data
public class CreateAppUserBo {

    /**
     * 创建时间 时间戳
     **/
    private String CreateTime;

    /**
     * 创建应用企业ID
     **/
    private String ToUserName;

    /**
     * 消息类型  默认是事件 event
     **/
    private String MsgType;

    /**
     * 事件类型  默认是订阅 subscribe
     **/
    private String Event;

    /**
     * 应用安装人
     **/
    private String FromUserName;

    /**
     * 应用ID
     **/
    private String AgentID;

}

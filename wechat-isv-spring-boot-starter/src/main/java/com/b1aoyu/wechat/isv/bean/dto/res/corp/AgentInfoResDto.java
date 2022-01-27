package com.b1aoyu.wechat.isv.bean.dto.res.corp;

import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:授权的应用信息，注意是一个数组，但仅旧的多应用套件授权时会返回多个agent，对新的单应用授权，永远只返回一个agent
 */
@Data
public class AgentInfoResDto {

    /**
     * 授权方应用id
     **/
    private String agentid;

    /**
     * 授权方应用名字
     **/
    private String name;

    /**
     * 授权方应用方形头像
     **/
    private String square_logo_url;

    /**
     * 授权方应用圆形头像
     **/
    private String round_logo_url;

    /**
     * 旧的多应用套件中的对应应用id，新开发者请忽略
     **/
    private String appid;

    /**
     * 授权模式，0为管理员授权；1为成员授权
     **/
    private String auth_mode;

    /**
     * 是否为代开发自建应用
     **/
    private String is_customized_app;

    /**
     * 应用对应的权限
     **/
    private PrivilegeResDto privilege;

    /**
     * 共享了应用的互联企业信息，仅当由互联的企业共享应用触发的安装时才返回
     **/
    private SharedFromResDto shared_from;

}

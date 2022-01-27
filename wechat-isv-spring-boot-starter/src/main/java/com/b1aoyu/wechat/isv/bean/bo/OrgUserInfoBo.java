package com.b1aoyu.wechat.isv.bean.bo;

import java.util.List;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-11
 * @description:部门内员工信息
 */
@Data
public class OrgUserInfoBo {

    /**
     * 成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节
     **/
    private String userid;

    /**
     * 成员名称；第三方不可获取，调用时返回userid以代替name；代开发自建应用需要管理员授权才返回；对于非第三方创建的成员，第三方通讯录应用也不可获取；未返回name的情况需要通过通讯录展示组件来展示名字
     **/
    private String name;

    /**
     * 成员所属部门id列表，仅返回该应用有查看权限的部门id；成员授权模式下，固定返回根部门id，即固定为1
     **/
    private List<String> department;

    /**
     * 全局唯一。对于同一个服务商，不同应用获取到企业内同一个成员的open_userid是相同的，最多64个字节。仅第三方应用可获取
     **/
    private String open_userid;

}

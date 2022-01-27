package com.b1aoyu.wechat.isv.bean.dto.res.corp;

import java.util.List;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description: 应用对应的权限
 */
@Data
public class PrivilegeResDto {

    /**
     * 应用可见范围（部门）
     **/
    private List<String> allow_party;

    /**
     * 应用可见范围（标签）
     **/
    private List<String> allow_tag;

    /**
     * 应用可见范围（成员）
     **/
    private List<String> allow_user;

    /**
     * 额外通讯录（部门）
     **/
    private List<String> extra_party;

    /**
     * 额外通讯录（成员）
     **/
    private List<String> extra_user;

    /**
     * 额外通讯录（标签）
     **/
    private List<String> extra_tag;

    /**
     * 权限等级。
     * 1:通讯录基本信息只读
     * 2:通讯录全部信息只读
     * 3:通讯录全部信息读写
     * 4:单个基本信息只读
     * 5:通讯录全部信息只写
     **/
    private String level;

}

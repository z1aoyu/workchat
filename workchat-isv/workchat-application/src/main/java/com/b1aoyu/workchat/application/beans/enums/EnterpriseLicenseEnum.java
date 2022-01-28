package com.b1aoyu.workchat.application.beans.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author z1aoyu 2022-01-28
 **/
@Getter
@AllArgsConstructor
public enum EnterpriseLicenseEnum {


    CHANGE_CONTACT("change_contact", "变更内容"),

    SUITE_TICKET("suite_ticket", "推送suite_ticket应用票据"),

    CREATE_AUTH("create_auth", "授权成功通知"),

    CHANGE_AUTH("change_auth", "授权变更通知"),

    CANCEL_AUTH("cancel_auth", "授权取消通知"),

    CREATE_USER("create_user", "创建成员通知"),

    UPDATE_USER("update_user", "更新成员通知"),

    DELETE_USER("delete_user", "删除成员通知"),

    CREATE_PARTY("create_party", "创建部门通知"),

    UPDATE_PARTY("update_party", "更新部门通知"),

    DELETE_PARTY("delete_party", "删除部门通知"),

    UPDATE_TAG("update_tag", "变更标签通知"),

    SHARE_AGENT_CHANGE("share_agent_change", "企业互联共享应用事件回调"),

    SHARE_CHAIN_CHANGE("share_chain_change", "上下游共享应用事件回调"),

    CHANGE_APP_ADMIN("change_app_admin", "应用管理员变更通知");

    private final String code;

    private final String title;

    /**
     * 判断参数code是否是一个有效的枚举
     */
    public static boolean valid(String code) {
        return Arrays.stream(values()).anyMatch(anEnum -> anEnum.getCode().equals(code));
    }

    /**
     * 获取code对应的枚举
     */
    public static EnterpriseLicenseEnum of(String code) {
        return Arrays.stream(values()).filter(anEnum -> anEnum.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "EnterpriseLicenseEnum{" + "code='" + code + '\'' + ", title='" + title + '\'' + '}';
    }
}
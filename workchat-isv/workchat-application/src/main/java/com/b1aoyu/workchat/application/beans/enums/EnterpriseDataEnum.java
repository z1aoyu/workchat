package com.b1aoyu.workchat.application.beans.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author z1aoyu 2022-01-28
 *         企业授权
 **/
@Getter
@AllArgsConstructor
public enum EnterpriseDataEnum {


    SUBSCRIBE("subscribe", "订阅事件"),

    UNSUBSCRIBE("unsubscribe", "取消订阅事件"),

    CHANGE_APP_ADMIN("change_app_admin", "应用管理员变更事件"),

    ENTER_AGENT("enter_agent", "成员进入应用");

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
    public static EnterpriseDataEnum of(String code) {
        return Arrays.stream(values()).filter(anEnum -> anEnum.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "EnterpriseDataEnum{" + "code='" + code + '\'' + ", title='" + title + '\'' + '}';
    }
}
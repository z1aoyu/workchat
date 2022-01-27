package com.b1aoyu.wechat.isv.bean.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author：z1aoyu 2022-01-07
 * @description:应用授权作用域
 */
@Getter
@AllArgsConstructor
public enum ThirdScopeEnum {

    SNSAPI_BASE("snsapi_base", "静默授权，可获取成员的基础信息（UserId与DeviceId）"),

    SNSAPI_USERINFO("snsapi_userinfo", "静默授权，可获取成员的详细信息，但不包含头像、二维码等敏感信息"),

    SNSAPI_PRIVATEINFO("snsapi_privateinfo", "手动授权，可获取成员的详细信息，包含头像、二维码等敏感信息");

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
    public static ThirdScopeEnum of(String code) {
        return Arrays.stream(values()).filter(anEnum -> anEnum.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "ThirdScopeEnum{" + "code='" + code + '\'' + ", title='" + title + '\'' + '}';
    }
}
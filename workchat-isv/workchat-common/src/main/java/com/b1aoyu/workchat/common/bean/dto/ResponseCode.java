package com.b1aoyu.workchat.common.bean.dto;

import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author z1aoyu 2022-01-28
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS("B00000", "操作成功"),

    ERROR("B00001", "操作失败"),

    ILLEGAL_PARAMETER("B00003", "非法参数");

    @JsonValue
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
    @JsonCreator
    public static ResponseCode of(String code) {
        return Arrays.stream(values()).filter(anEnum -> anEnum.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "ResponseCode{" + "code='" + code + '\'' + ", title='" + title + '\'' + '}';
    }
}
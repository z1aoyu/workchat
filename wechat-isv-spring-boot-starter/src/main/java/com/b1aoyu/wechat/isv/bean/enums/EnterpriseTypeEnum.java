package com.b1aoyu.wechat.isv.bean.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author z1aoyu 2022-01-06
 **/
@Getter
@AllArgsConstructor
public enum EnterpriseTypeEnum {

    INFO_TYPE("InfoType", "消息类型"),

    CHANGE_TYPE("ChangeType", "变更类型"),

    Event("Event", "事件类型"),

    MSG_SIGNATURE("msg_signature", "企业微信加密签名"),

    NONCE("nonce", "随机数"),

    TIMESTAMP("timestamp", "时间戳"),

    SUCCESS("success", "响应结果成功");


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
    public static EnterpriseTypeEnum of(String code) {
        return Arrays.stream(values()).filter(anEnum -> anEnum.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "EnterpriseTypeEnum{" + "code='" + code + '\'' + ", title='" + title + '\'' + '}';
    }
}
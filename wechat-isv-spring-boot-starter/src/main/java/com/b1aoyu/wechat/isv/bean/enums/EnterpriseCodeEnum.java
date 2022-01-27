package com.b1aoyu.wechat.isv.bean.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author z1aoyu 2022-01-06
 **/
@Getter
@AllArgsConstructor
public enum EnterpriseCodeEnum {

    SUITE_TOKEN("suiteToken", "第三方应用凭证"),

    SUITE_ID("suiteId", "第三方服务商列表应用ID"),

    ACCESS_TOKEN("accessToken", "企业凭证"),

    ORG_ID("orgId", "部门Id"),

    FETCH_CHILD("isChild", "是否递归获取子部门下面的成员：1-递归获取，0-只获取本部门"),

    USER_ID("thirdUserId", "用户Id"),

    THIRD_AGENTID("thirdAgentid", "企业用户安装后生成的应用id"),

    PRE_AUTH_CODE("preAuthCode", "企业预授权码"),

    REDIRECT_URI("redirectURL", "授权完成回调URI 需要经过一次urlencode作为参数"),

    RANDOM_STATE("randomState", "state可填a-zA-Z0-9的参数值（不超过128个字节），用于第三方自行校验session，防止跨域攻击。"),

    THIRD_APPID("thirdAppId", "第三方应用id（即ww或wx开头的suite_id）。注意与企业的网页授权登录不同"),

    SCOPE("thirdScope", "应用授权作用域。\n" + "snsapi_base：静默授权，可获取成员的基础信息（UserId与DeviceId）；\n" + "snsapi_userinfo：静默授权，可获取成员的详细信息，但不包含头像、二维码等敏感信息；\n"
            + "snsapi_privateinfo：手动授权，可获取成员的详细信息，包含头像、二维码等敏感信息。"),

    USER_CODE("userCode", "通过成员授权获取到的code，最大为512字节。每次成员授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期");


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
    public static EnterpriseCodeEnum of(String code) {
        return Arrays.stream(values()).filter(anEnum -> anEnum.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "EnterpriseCodeEnum{" + "code='" + code + '\'' + ", title='" + title + '\'' + '}';
    }
}
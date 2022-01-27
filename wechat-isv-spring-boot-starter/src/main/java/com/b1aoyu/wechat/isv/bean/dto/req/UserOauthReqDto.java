package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import com.b1aoyu.wechat.isv.bean.enums.ThirdScopeEnum;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:
 */
@Data
public class UserOauthReqDto {

    /**
     * 第三方应用id（即ww或wx开头的suite_id）。注意与企业的网页授权登录不同
     **/
    @NotNull
    private String appId;

    /**
     * {@link ThirdScopeEnum 授权方式}
     **/
    @NotNull
    private ThirdScopeEnum thirdScopeEnum;

    /**
     * 用户授权回调地址（身份验证回调地址）
     **/
    @NotNull
    private String userOauthUrl;

}

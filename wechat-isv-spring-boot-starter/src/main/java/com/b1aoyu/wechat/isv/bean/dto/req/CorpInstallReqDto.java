package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:
 */
@Data
public class CorpInstallReqDto {

    /**
     * 第三方应用id（即ww或wx开头的suite_id）。注意与企业的网页授权登录不同
     **/
    @NotNull
    private String suiteId;

    /**
     * 预授权码
     **/
    @NotNull
    private String preAuthCode;

    /**
     * 企业授权回调地址
     **/
    @NotNull
    private String corpOauthUrl;

}

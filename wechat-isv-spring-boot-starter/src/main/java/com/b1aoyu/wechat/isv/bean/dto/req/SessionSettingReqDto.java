package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:设置授权配置
 */
@Data
public class SessionSettingReqDto {

    /**
     * 第三方应用凭证
     **/
    @NotNull
    private String suite_access_token;

    /**
     * 预授权码
     **/
    @NotNull
    private String pre_auth_code;

    /**
     * 第三方应用凭证
     **/
    @NotNull
    private SessionInfoReqDto session_info;



}

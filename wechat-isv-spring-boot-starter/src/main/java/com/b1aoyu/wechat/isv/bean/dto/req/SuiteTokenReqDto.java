package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author z1aoyu 2022-01-06
 **/
@Data
public class SuiteTokenReqDto {

    /**
     * 以ww或wx开头应用id（对应于旧的以tj开头的套件id）
     **/
    @NotNull
    private String suite_id;

    /**
     * 应用secret
     **/
    @NotNull
    private String suite_secret;

    /**
     * 企业微信后台推送的ticket
     **/
    @NotNull
    private String suite_ticket;

}

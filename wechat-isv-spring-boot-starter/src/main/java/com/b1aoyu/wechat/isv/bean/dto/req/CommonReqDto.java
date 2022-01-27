package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author z1aoyu 2022-01-06
 * 可用于获取企业凭证、企业授权信息
 **/
@Data
public class CommonReqDto {

    /**
     * 授权方corpid
     **/
    @NotNull
    private String auth_corpid;

    /**
     * 企业永久授权码，通过get_permanent_code获取
     **/
    @NotNull
    private String permanent_code;

}

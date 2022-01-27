package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:企业授权信息DTO
 */
@Data
public class AuthorizationInfoReqDto {

    /**
     * 授权方corpid
     **/
    @NotNull
    private String auth_corpid;

    /**
     * 永久授权码，通过get_permanent_code获取
     **/
    @NotNull
    private String permanent_code;

}

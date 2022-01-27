package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:企业永久授权码DTO
 */
@Data
public class PermanentCodeReqDto {

    /**
     * 临时授权码，会在授权成功时附加在redirect_uri中跳转回第三方服务商网站，或通过授权成功通知回调推送给服务商。长度为64至512个字节
     **/
    @NotNull
    private String auth_code;

}

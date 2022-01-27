package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-11
 * @description: 查询用户信息DTO
 */
@Data
public class UserReqDto {

    /**
     * 调用接口凭证
     **/
    @NotNull
    private String access_token;

    /**
     * 成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节
     **/
    @NotNull
    private String userid;

}

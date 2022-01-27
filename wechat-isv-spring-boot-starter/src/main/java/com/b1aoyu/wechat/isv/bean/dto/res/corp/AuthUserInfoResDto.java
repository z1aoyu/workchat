package com.b1aoyu.wechat.isv.bean.dto.res.corp;

import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:授权管理员的信息，可能不返回（企业互联由上级企业共享第三方应用给下级时，不返回授权的管理员信息）
 */
@Data
public class AuthUserInfoResDto {


    /**
     * 授权管理员的userid，可能为空（企业互联由上级企业共享第三方应用给下级时，不返回授权的管理员信息）
     **/
    private String userid;

    /**
     * 授权管理员的open_userid，可能为空（企业互联由上级企业共享第三方应用给下级时，不返回授权的管理员信息）
     **/
    private String open_userid;

    /**
     * 授权管理员的name，可能为空（企业互联由上级企业共享第三方应用给下级时，不返回授权的管理员信息）
     **/
    private String name;

    /**
     * 授权管理员的头像url，可能为空（企业互联由上级企业共享第三方应用给下级时，不返回授权的管理员信息）
     **/
    private String avatar;

}

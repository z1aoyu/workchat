package com.b1aoyu.wechat.isv.bean.dto.res.corp.permanentcode;

import com.b1aoyu.wechat.isv.bean.dto.res.corp.AuthUserInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.AuthCorpInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.AuthInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.DealerCorpInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.RegisterCodeInfoResDto;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:企业永久授权码DTO
 */
@Data
public class PermanentCodeResDto {

    /**
     * 错误码，0表示正常返回，可读取admin的管理员列表
     **/
    private String errcode;

    /**
     * 对返回码的文本描述内容
     **/
    private String errmsg;

    /**
     * 授权方（企业）access_token,最长为512字节
     **/
    private String access_token;

    /**
     * 授权方（企业）access_token超时时间（秒）
     **/
    private String expires_in;

    /**
     * 企业微信永久授权码,最长为512字节
     **/
    private String permanent_code;

    /**
     * 授权方企业信息
     **/
    private AuthCorpInfoResDto auth_corp_info;

    /**
     * 授权信息。如果是通讯录应用，且没开启实体应用，是没有该项的。通讯录应用拥有企业通讯录的全部信息读写权限
     **/
    private AuthInfoResDto auth_info;

    /**
     * 授权管理员的信息，可能不返回（企业互联由上级企业共享第三方应用给下级时，不返回授权的管理员信息）
     **/
    private AuthUserInfoResDto auth_user_info;

    /**
     * 代理服务商企业信息。应用被代理后才有该信息
     **/
    private DealerCorpInfoResDto dealer_corp_info;

    /**
     * 推广二维码安装相关信息，扫推广二维码安装时返回。（注：无论企业是否新注册，只要通过扫推广二维码安装，都会返回该字段）
     **/
    private RegisterCodeInfoResDto register_code_info;

}

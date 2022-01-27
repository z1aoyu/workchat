package com.b1aoyu.wechat.isv.bean.dto.res.corp.authorizationinfo;

import com.b1aoyu.wechat.isv.bean.dto.res.corp.AuthCorpInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.AuthInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.DealerCorpInfoResDto;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:企业授权信息
 */
@Data
public class AuthorizationInfoResDto {
    /**
     * 错误码，0表示正常返回，可读取admin的管理员列表
     **/
    private String errcode;

    /**
     * 对返回码的文本描述内容
     **/
    private String errmsg;

    /**
     * 授权方企业信息
     **/
    private AuthCorpInfoResDto auth_corp_info;

    /**
     * 授权信息。如果是通讯录应用，且没开启实体应用，是没有该项的。通讯录应用拥有企业通讯录的全部信息读写权限
     **/
    private AuthInfoResDto auth_info;

    /**
     * 授权信息。如果是通讯录应用，且没开启实体应用，是没有该项的。通讯录应用拥有企业通讯录的全部信息读写权限
     **/
    private DealerCorpInfoResDto dealer_corp_info;

}

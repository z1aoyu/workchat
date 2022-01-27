package com.b1aoyu.wechat.isv.bean.dto.res;

import com.b1aoyu.wechat.isv.bean.dto.res.corp.org.OrgResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.user.UserResDto;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-10
 * @description:
 */
@Data
public class AppInfoResDto {

    /**
     * 错误码，0表示正常返回，可读取admin的管理员列表
     **/
    private String errcode;

    /**
     * 错误说明
     **/
    private String errmsg;

    /**
     * 企业应用可见范围（人员），其中包括userid
     **/
    private UserResDto allow_userinfos;

    /**
     * 授权信息。如果是通讯录应用，且没开启实体应用，是没有该项的。通讯录应用拥有企业通讯录的全部信息读写权限
     **/
    private OrgResDto allow_partys;

}

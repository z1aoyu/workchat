package com.b1aoyu.wechat.isv.bean.dto.res.corp;

import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:授权方企业信息DTO
 */
@Data
public class AuthCorpInfoResDto {


    /**
     * 授权方企业微信id
     **/
    private String corpid;

    /**
     * 授权方企业名称，即企业简称
     **/
    private String corp_name;

    /**
     * 授权方企业类型，认证号：verified, 注册号：unverified
     **/
    private String corp_type;

    /**
     * 授权方企业方形头像
     **/
    private String corp_square_logo_url;

    /**
     * 授权方企业用户规模
     **/
    private String corp_user_max;

    /**
     * 	授权方企业的主体名称(仅认证或验证过的企业有)，即企业全称。
     **/
    private String corp_full_name;

    /**
     * 企业类型，1. 企业; 2. 政府以及事业单位; 3. 其他组织, 4.团队号
     **/
    private String subject_type;

    /**
     * 认证到期时间
     **/
    private String verified_end_time;

    /**
     * 授权企业在微工作台（原企业号）的二维码，可用于关注微工作台
     **/
    private String corp_wxqrcode;

    /**
     * 企业规模。当企业未设置该属性时，值为空
     **/
    private String corp_scale;

    /**
     * 企业所属行业。当企业未设置该属性时，值为空
     **/
    private String corp_industry;

    /**
     * 企业所属子行业。当企业未设置该属性时，值为空
     **/
    private String corp_sub_industry;


}

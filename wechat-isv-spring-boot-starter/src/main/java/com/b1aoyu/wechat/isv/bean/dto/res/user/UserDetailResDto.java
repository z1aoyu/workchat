package com.b1aoyu.wechat.isv.bean.dto.res.user;

import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description: 用户敏感信息
 */
@Data
public class UserDetailResDto {

    /**
     * 错误码，0表示正常返回，可读取admin的管理员列表
     **/
    private String errcode;

    /**
     * 对返回码的文本描述内容
     **/
    private String errmsg;

    /**
     * 用户所属企业的corpid
     **/
    private String corpid;

    /**
     * 成员UserID
     **/
    private String userid;

    /**
     * 成员姓名，此字段从2019年12月30日起，对新创建第三方应用不再返回真实name，使用userid代替name返回，2020年6月30日起，对所有历史第三方应用不再返回，第三方页面需要通过通讯录展示组件来展示名字
     **/
    private String name;

    /**
     * 性别。0表示未定义，1表示男性，2表示女性。仅在用户同意snsapi_privateinfo授权时返回真实值，否则返回0.
     **/
    private String gender;

    /**
     * 头像url。仅在用户同意snsapi_privateinfo授权时返回
     **/
    private String avatar;

    /**
     * 员工个人二维码（扫描可添加为外部联系人），仅在用户同意snsapi_privateinfo授权时返回
     **/
    private String qr_code;

}

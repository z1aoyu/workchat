package com.b1aoyu.wechat.isv.bean.dto.res.user;

import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:获取访问用户身份DTO
 */
@Data
public class UserInfoResDto {

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
    private String CorpId;

    /**
     * 用户在企业内的UserID，如果该企业与第三方应用有授权关系时，返回明文UserId，否则返回密文UserId
     **/
    private String UserId;

    /**
     * 手机设备号(由企业微信在安装时随机生成，删除重装会改变，升级不受影响)
     **/
    private String DeviceId;

    /**
     * 成员票据，最大为512字节。
     * scope为snsapi_userinfo或snsapi_privateinfo，且用户在应用可见范围之内时返回此参数。
     * 后续利用该参数可以获取用户信息或敏感信息，参见“第三方使用user_ticket获取成员详情 https://work.weixin.qq.com/api/doc/90001/90143/91121#15123”。
     **/
    private String user_ticket;


    /**
     * user_ticket的有效时间（秒），随user_ticket一起返回
     **/
    private String expires_in;

    /**
     * 全局唯一。对于同一个服务商，不同应用获取到企业内同一个成员的open_userid是相同的，最多64个字节。仅第三方应用可获取
     **/
    private String open_userid;

    /**
     * 若用户不属于任何企业，返回示例如下：
     *  {
     *    "errcode": 0,
     *    "errmsg": "ok",
     *    "OpenId":"OPENID",
     *    "DeviceId":"DEVICEID"
     * }
     *
     * openId只有当用户不属于任何企业的时候才会返回
     **/
    
    /**
     * 非企业成员的标识，对当前服务商唯一
     **/
    private String OpenId;

}

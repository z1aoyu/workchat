package com.b1aoyu.wechat.isv.utils.constant;

/**
 * @author z1aoyu 2022-01-06
 **/
public final class WechatUrl {

    private WechatUrl() {
    }

    /**
     * 获取第三方应用凭证
     **/
    public static final String SUITE_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/get_suite_token";

    /**
     * 获取企业应用凭证
     **/
    public static final String CORP_ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/get_corp_token?suite_access_token=suiteToken";

    /**
     * 获取企业应用的管理员列表
     **/
    public static final String ADMIN_LIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/get_admin_list?suite_access_token=suiteToken";

    /**
     * 获取企业预授权码
     **/
    public static final String PRE_AUTH_CODE_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/get_pre_auth_code?suite_access_token=suiteToken";

    /**
     * 获取企业永久授权码
     **/
    public static final String PERMANENT_CODE_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/get_permanent_code?suite_access_token=suiteToken";

    /**
     * 获取企业授权信息
     **/
    public static final String AUTH_INFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/get_auth_info?suite_access_token=suiteToken";

    /**
     * 获取访问用户身份
     **/
    public static final String USER_INFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/getuserinfo3rd?suite_access_token=suiteToken&code=userCode";

    /**
     * 获取用户敏感信息
     **/
    public static final String USER_DETAIL_INFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/getuserdetail3rd?suite_access_token=suiteToken";

    /**
     * 设置授权配置
     **/
    public static final String SESSION_INFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/service/set_session_info?suite_access_token=suiteToken";

    /**
     * 获取企业的jsapi_ticket
     **/
    public static final String JSAPI_TICKET = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=accessToken";

    /**
     * 获取应用的jsapi_ticket
     **/
    public static final String AGAIN_TICKET = "https://qyapi.weixin.qq.com/cgi-bin/ticket/get?access_token=accessToken&type=agent_config";


    /**
     * 构造企业应用安装授权链接
     **/
    public static final String INSTALL_URL =
            "https://open.work.weixin.qq.com/3rdapp/install?suite_id=suiteId&pre_auth_code=preAuthCode&redirect_uri=redirectURL" + "&state=randomState";

    /**
     * 构造用户Oauth2授权链接
     **/
    public static final String AUTHORIZE_URL =
            "https://open.weixin.qq.com/connect/oauth2/authorize?appid=thirdAppId&redirect_uri=redirectURL&response_type=code&scope=thirdScope"
                    + "&state=randomState#wechat_redirect";


    /**
     * 获取指定的应用详情
     **/
    public static final String APP_INFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token=accessToken&agentid=thirdAgentid";


    /**
     * 获取部门列表
     **/

    public static final String ORG_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=accessToken&id=orgId";

    /**
     * 获取子部门Id列表
     **/
    public static final String SUBORDINATE_ORG_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/simplelist?access_token=accessToken&id=orgId";

    /**
     * 获取单个部门Id
     **/
    public static final String SINGLE_ORG_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/get?access_token=accessToken&id=orgId";

    /**
     * 读取成员URL
     **/
    public static final String USER_ID = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=accessToken&userid=thirdUserId";

    /**
     * 获取部门成员URL
     **/
    public static final String ORG_USE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=accessToken&department_id=orgId&fetch_child=isChild";

    /**
     * 获取部门成员详情
     **/
    public static final String ORG_USER_INFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=accessToken&department_id=orgId&fetch_child=isChild";

}

package com.b1aoyu.wechat.isv.utils;


import java.io.IOException;
import com.b1aoyu.wechat.isv.bean.dto.req.AdminReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.AppInfoReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.AuthorizationInfoReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.CommonReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.CorpInstallReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.OrgReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.OrgUserReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.PermanentCodeReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.SessionSettingReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.SuiteTokenReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.UserDetailReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.UserOauthReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.UserReqDto;
import com.b1aoyu.wechat.isv.bean.dto.res.AccessTokenResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.AdminResListDto;
import com.b1aoyu.wechat.isv.bean.dto.res.AppInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.PreAuthorizationResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.SessionSettingResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.SuiteTokenResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.TicketDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.authorizationinfo.AuthorizationInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.org.OrgInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.org.SingleOrgInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.org.SubordinateOrgResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.permanentcode.PermanentCodeResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.user.OrgUserDetailResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.user.OrgUserResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.user.ReadUserInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.user.UserDetailResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.user.UserInfoResDto;
import com.b1aoyu.wechat.isv.bean.enums.EnterpriseCodeEnum;
import com.b1aoyu.wechat.isv.utils.constant.WechatUrl;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;

/**
 * @author z1aoyu 2022-01-06
 **/
@Slf4j
public class WechatCommonUtil {

    private WechatCommonUtil() {
    }

    /**
     * 获取第三方应用凭证
     **/
    public static SuiteTokenResDto getSuiteToken(SuiteTokenReqDto suiteToken) {
        SuiteTokenResDto suiteTokenResDto = null;
        String jsonBody = JSONUtil.toJsonStr(suiteToken);
        try {
            Response result = HttpUtil.postJson(WechatUrl.SUITE_TOKEN_URL, jsonBody, null);
            if (result.body() != null) {
                suiteTokenResDto = JSONUtil.toBean(result.body().string(), SuiteTokenResDto.class);
            }
        } catch (IOException e) {
            log.error("获取获取第三方应用凭证失败");
            e.printStackTrace();
        }
        return suiteTokenResDto;
    }

    /**
     * 获取预授权码
     *
     * @param suiteToken 第三方企业应用凭证
     **/
    public static PreAuthorizationResDto preAuthCode(String suiteToken) {
        PreAuthorizationResDto preAuthorizationResDto = null;
        String requestUrl = WechatUrl.PRE_AUTH_CODE_URL.replace(EnterpriseCodeEnum.SUITE_TOKEN.getCode(), suiteToken);

        try {
            Response result = HttpUtil.get(requestUrl, null);
            if (result.body() != null) {
                preAuthorizationResDto = JSONUtil.toBean(result.body().string(), PreAuthorizationResDto.class);
            }
        } catch (IOException e) {
            log.error("获取预授权码失败");
            e.printStackTrace();
        }
        return preAuthorizationResDto;
    }

    /**
     * 获取企业永久授权码
     *
     * @param suiteToken 第三方企业应用凭证
     **/
    public static PermanentCodeResDto permanentCode(String suiteToken, PermanentCodeReqDto permanentCodeReqDto) {
        PermanentCodeResDto permanentCodeResDto = null;
        String requestUrl = WechatUrl.PERMANENT_CODE_URL.replace(EnterpriseCodeEnum.SUITE_TOKEN.getCode(), suiteToken);
        String jsonBody = JSONUtil.toJsonStr(permanentCodeReqDto);
        try {
            Response result = HttpUtil.postJson(requestUrl, jsonBody, null);
            if (result.body() != null) {
                permanentCodeResDto = JSONUtil.toBean(result.body().string(), PermanentCodeResDto.class);
            }
        } catch (IOException e) {
            log.error("获取获取企业永久授权码失败");
            e.printStackTrace();
        }
        return permanentCodeResDto;
    }

    /**
     * 获取企业授权信息
     *
     * @param suiteToken 第三方企业应用凭证
     **/
    public static AuthorizationInfoResDto authorizationInfo(String suiteToken, AuthorizationInfoReqDto authorizationInfoReqDtoa) {
        AuthorizationInfoResDto authorizationInfoResDto = null;
        String requestUrl = WechatUrl.AUTH_INFO_URL.replace(EnterpriseCodeEnum.SUITE_TOKEN.getCode(), suiteToken);
        String jsonBody = JSONUtil.toJsonStr(authorizationInfoReqDtoa);
        try {
            Response result = HttpUtil.postJson(requestUrl, jsonBody, null);
            String string = null;
            if (result.body() != null) {
                string = result.body().string();
            }
            authorizationInfoResDto = JSONUtil.toBean(string, AuthorizationInfoResDto.class);
        } catch (IOException e) {
            log.error("获取企业授权信息失败");
            e.printStackTrace();
        }
        return authorizationInfoResDto;
    }


    /**
     * 获取访问用户身份
     *
     * @param suiteToken 第三方企业应用凭证
     * @param userCode 通过成员授权获取到的code，最大为512字节。每次成员授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
     **/
    public static UserInfoResDto userInfo(String suiteToken, String userCode) {
        UserInfoResDto userInfoResDto = null;
        String requestUrl = WechatUrl.USER_INFO_URL.replace(EnterpriseCodeEnum.SUITE_TOKEN.getCode(), suiteToken)
                .replace(EnterpriseCodeEnum.USER_CODE.getCode(), userCode);
        try {
            Response result = HttpUtil.get(requestUrl, null);
            String string = null;
            if (result.body() != null) {
                string = result.body().string();
            }
            userInfoResDto = JSONUtil.toBean(string, UserInfoResDto.class);
        } catch (IOException e) {
            log.error("获取访问用户身份失败");
            e.printStackTrace();
        }
        return userInfoResDto;
    }


    /**
     * 获取敏感用户身份
     *
     * @param suiteToken 第三方企业应用凭证
     **/
    public static UserDetailResDto userInfo(String suiteToken, UserDetailReqDto userDetailReqDto) {
        UserDetailResDto userDetailResDto = null;
        String requestUrl = WechatUrl.USER_DETAIL_INFO_URL.replace(EnterpriseCodeEnum.SUITE_TOKEN.getCode(), suiteToken);
        String jsonBody = JSONUtil.toJsonStr(userDetailReqDto);
        try {
            Response result = HttpUtil.postJson(requestUrl, jsonBody, null);
            String jsonStr = null;
            if (result.body() != null) {
                jsonStr = result.body().string();
            }
            userDetailResDto = JSONUtil.toBean(jsonStr, UserDetailResDto.class);
        } catch (IOException e) {
            log.error("获取敏感用户身份失败");
            e.printStackTrace();
        }
        return userDetailResDto;
    }


    /**
     * 获取企业应用Token
     *
     * @param suiteToken 第三方企业应用凭证
     **/
    public static AccessTokenResDto getAccessToken(String suiteToken, CommonReqDto commonReqDto) {
        AccessTokenResDto accessToken = null;

        String requestUrl = WechatUrl.CORP_ACCESS_TOKEN_URL.replace(EnterpriseCodeEnum.SUITE_TOKEN.getCode(), suiteToken);
        String jsonBody = JSONUtil.toJsonStr(commonReqDto);

        try {
            Response result = HttpUtil.postJson(requestUrl, jsonBody, null);
            if (result.body() != null) {
                accessToken = JSONUtil.toBean(result.body().string(), AccessTokenResDto.class);
            }
        } catch (IOException e) {
            log.error("获取企业应用Token失败");
            e.printStackTrace();
        }
        return accessToken;
    }


    /**
     * 获取应用的管理员列表
     *
     * @param suiteToken 第三方企业应用凭证
     **/
    public static AdminResListDto adminList(String suiteToken, AdminReqDto adminReqDto) {
        AdminResListDto adminResListDto = new AdminResListDto();
        String requestUrl = WechatUrl.ADMIN_LIST_URL.replace(EnterpriseCodeEnum.SUITE_TOKEN.getCode(), suiteToken);
        String jsonBody = JSONUtil.toJsonStr(adminReqDto);

        try {
            Response result = HttpUtil.postJson(requestUrl, jsonBody, null);
            if (result.body() != null) {
                adminResListDto = JSONUtil.toBean(result.body().string(), AdminResListDto.class);
            }
        } catch (IOException e) {
            log.error("获取应用的管理员列表失败");
            e.printStackTrace();
        }
        return adminResListDto;
    }


    /**
     * 设置授权配置
     *
     * @param suiteToken 第三方企业应用凭证
     **/
    public static SessionSettingResDto sessionSetting(String suiteToken, SessionSettingReqDto sessionSettingReqDto) {
        SessionSettingResDto sessionSettingResDto = new SessionSettingResDto();
        String requestUrl = WechatUrl.SESSION_INFO_URL.replace(EnterpriseCodeEnum.SUITE_TOKEN.getCode(), suiteToken);
        String jsonBody = JSONUtil.toJsonStr(sessionSettingReqDto);

        try {
            Response result = HttpUtil.postJson(requestUrl, jsonBody, null);
            if (result.body() != null) {
                sessionSettingResDto = JSONUtil.toBean(result.body().string(), SessionSettingResDto.class);
            }
        } catch (IOException e) {
            log.error("设置授权配置失败");
            e.printStackTrace();
        }
        return sessionSettingResDto;
    }


    /**
     * 构造用户Oauth2授权链接
     **/
    public static String userOauthURL(UserOauthReqDto userOauthReqDto) {
        return WechatUrl.AUTHORIZE_URL.replace(EnterpriseCodeEnum.THIRD_APPID.getCode(), userOauthReqDto.getAppId())
                .replace(EnterpriseCodeEnum.REDIRECT_URI.getCode(), userOauthReqDto.getUserOauthUrl())
                .replace(EnterpriseCodeEnum.SCOPE.getCode(), userOauthReqDto.getThirdScopeEnum().getCode());
    }


    /**
     * 构造企业安装授权链接
     **/
    public static String corpInstall(CorpInstallReqDto corpInstallReqDto) {
        return WechatUrl.INSTALL_URL.replace(EnterpriseCodeEnum.SUITE_ID.getCode(), corpInstallReqDto.getSuiteId())
                .replace(EnterpriseCodeEnum.REDIRECT_URI.getCode(), corpInstallReqDto.getCorpOauthUrl())
                .replace(EnterpriseCodeEnum.PRE_AUTH_CODE.getCode(), corpInstallReqDto.getPreAuthCode());
    }


    /**
     * 获取指定的应用详情
     **/
    public static AppInfoResDto appInfo(AppInfoReqDto appInfoReqDto) {
        AppInfoResDto appInfoResDto = null;
        String replace = WechatUrl.APP_INFO_URL.replace(EnterpriseCodeEnum.THIRD_AGENTID.getCode(), appInfoReqDto.getAgentid())
                .replace(EnterpriseCodeEnum.ACCESS_TOKEN.getCode(), appInfoReqDto.getAccess_token());
        try {
            Response result = HttpUtil.get(replace, null);
            if (result.body() != null) {
                appInfoResDto = JSONUtil.toBean(result.body().string(), AppInfoResDto.class);
            }
        } catch (IOException e) {
            log.error("获取指定的应用详情失败");
            e.printStackTrace();
        }
        return appInfoResDto;
    }

    /**
     * 获取部门ID列表
     **/
    public static OrgInfoResDto orgURL(OrgReqDto orgReqDto) {
        OrgInfoResDto orgInfoResDto = null;
        String replace = WechatUrl.ORG_URL.replace(EnterpriseCodeEnum.ACCESS_TOKEN.getCode(), orgReqDto.getAccess_token())
                .replace(EnterpriseCodeEnum.ORG_ID.getCode(), orgReqDto.getId());
        try {
            Response result = HttpUtil.get(replace, null);
            if (result.body() != null) {
                orgInfoResDto = JSONUtil.toBean(result.body().string(), OrgInfoResDto.class);
            }
        } catch (IOException e) {
            log.error("获取部门ID列表失败");
            e.printStackTrace();
        }
        return orgInfoResDto;
    }

    /**
     * 获取子部门ID列表
     **/
    public static SubordinateOrgResDto subordinateOrgURL(OrgReqDto orgReqDto) {
        SubordinateOrgResDto subordinateOrgResDto = null;
        String replace = WechatUrl.SUBORDINATE_ORG_URL.replace(EnterpriseCodeEnum.ACCESS_TOKEN.getCode(), orgReqDto.getAccess_token())
                .replace(EnterpriseCodeEnum.ORG_ID.getCode(), orgReqDto.getId());
        try {
            Response result = HttpUtil.get(replace, null);
            if (result.body() != null) {
                subordinateOrgResDto = JSONUtil.toBean(result.body().string(), SubordinateOrgResDto.class);
            }
        } catch (IOException e) {
            log.error("获取子部门ID列表失败");
            e.printStackTrace();
        }
        return subordinateOrgResDto;
    }

    /**
     * 获取单部门信息
     **/
    public static SingleOrgInfoResDto singleOrgURL(OrgReqDto orgReqDto) {
        SingleOrgInfoResDto singleOrgInfoResDto = null;
        String replace = WechatUrl.SINGLE_ORG_URL.replace(EnterpriseCodeEnum.ACCESS_TOKEN.getCode(), orgReqDto.getAccess_token())
                .replace(EnterpriseCodeEnum.ORG_ID.getCode(), orgReqDto.getId());
        try {
            Response result = HttpUtil.get(replace, null);
            if (result.body() != null) {
                singleOrgInfoResDto = JSONUtil.toBean(result.body().string(), SingleOrgInfoResDto.class);
            }
        } catch (IOException e) {
            log.error("获取单部门信息失败");
            e.printStackTrace();
        }
        return singleOrgInfoResDto;
    }


    /**
     * 读取成员
     **/
    public static ReadUserInfoResDto readUserInfo(UserReqDto userReqDto) {
        ReadUserInfoResDto userInfoResDto = null;
        String replace = WechatUrl.USER_ID.replace(EnterpriseCodeEnum.ACCESS_TOKEN.getCode(), userReqDto.getAccess_token())
                .replace(EnterpriseCodeEnum.USER_ID.getCode(), userReqDto.getUserid());
        try {
            Response result = HttpUtil.get(replace, null);
            if (result.body() != null) {
                userInfoResDto = JSONUtil.toBean(result.body().string(), ReadUserInfoResDto.class);
            }
        } catch (IOException e) {
            log.error("获取AccoussToken失败");
            e.printStackTrace();
        }
        return userInfoResDto;
    }

    /**
     * 获取部门成员
     **/
    public static OrgUserResDto orgUserList(OrgUserReqDto orgUserReqDto) {
        OrgUserResDto orgUserResDto = null;
        String replace = WechatUrl.ORG_USE_URL.replace(EnterpriseCodeEnum.ACCESS_TOKEN.getCode(), orgUserReqDto.getAccessToken())
                .replace(EnterpriseCodeEnum.ORG_ID.getCode(), orgUserReqDto.getDepartmentId())
                .replace(EnterpriseCodeEnum.FETCH_CHILD.getCode(), orgUserReqDto.getFetchChild());
        try {
            Response result = HttpUtil.get(replace, null);
            if (result.body() != null) {
                orgUserResDto = JSONUtil.toBean(result.body().string(), OrgUserResDto.class);
            }
        } catch (IOException e) {
            log.error("获取AccoussToken失败");
            e.printStackTrace();
        }
        return orgUserResDto;
    }

    /**
     * 获取部门成员详情
     **/
    public static OrgUserDetailResDto orgUserDetail(OrgUserReqDto orgUserReqDto) {
        OrgUserDetailResDto orgUserDetailResDto = null;
        String replace = WechatUrl.ORG_USER_INFO_URL.replace(EnterpriseCodeEnum.ACCESS_TOKEN.getCode(), orgUserReqDto.getAccessToken())
                .replace(EnterpriseCodeEnum.ORG_ID.getCode(), orgUserReqDto.getDepartmentId())
                .replace(EnterpriseCodeEnum.FETCH_CHILD.getCode(), orgUserReqDto.getFetchChild());
        try {
            Response result = HttpUtil.get(replace, null);
            if (result.body() != null) {
                orgUserDetailResDto = JSONUtil.toBean(result.body().string(), OrgUserDetailResDto.class);
            }
        } catch (IOException e) {
            log.error("获取部门成员失败");
            e.printStackTrace();
        }
        return orgUserDetailResDto;
    }


    /**
     * 获取企业的jsapi_ticket
     **/
    public static TicketDto getJsAPITicket(String accessToken) {
        TicketDto ticketDto = null;
        String replace = WechatUrl.JSAPI_TICKET.replace(EnterpriseCodeEnum.ACCESS_TOKEN.getCode(), accessToken);
        try {
            Response result = HttpUtil.get(replace, null);
            if (result.body() != null) {
                ticketDto = JSONUtil.toBean(result.body().string(), TicketDto.class);
            }
        } catch (IOException e) {
            log.error("获取企业的jsapi_ticket失败");
            e.printStackTrace();
        }
        return ticketDto;
    }

    /**
     * 获取应用的jsapi_ticket
     **/
    public static TicketDto getAgentTicket(String accessToken) {
        TicketDto ticketDto = null;
        String replace = WechatUrl.AGAIN_TICKET.replace(EnterpriseCodeEnum.ACCESS_TOKEN.getCode(), accessToken);
        try {
            Response result = HttpUtil.get(replace, null);
            if (result.body() != null) {
                ticketDto = JSONUtil.toBean(result.body().string(), TicketDto.class);
            }
        } catch (IOException e) {
            log.error("获取应用的jsapi_ticket失败");
            e.printStackTrace();
        }
        return ticketDto;
    }

}

package com.b1aoyu.wechat.isv.service.user;


import com.b1aoyu.wechat.isv.bean.dto.SuiteAccessonReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.AdminReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.OrgUserReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.UserDetailReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.UserOauthReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.UserReqDto;
import com.b1aoyu.wechat.isv.bean.dto.res.AdminResListDto;
import com.b1aoyu.wechat.isv.bean.dto.res.user.OrgUserDetailResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.user.OrgUserResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.user.ReadUserInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.user.UserDetailResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.user.UserInfoResDto;

/**
 * @author z1aoyu 2022-01-06
 **/
public interface IUserService {


    /**
     * 用户Oauth2授权链接
     **/
    String userOauthURL(UserOauthReqDto userOauthReqDto);

    /**
     * 获取访问用户身份
     *
     * @param suiteToken 第三方企业应用凭证
     * @param userCode 通过成员授权获取到的code，最大为512字节。每次成员授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
     **/
    UserInfoResDto userInfo(SuiteAccessonReqDto suiteToken, String userCode);

    /**
     * 获取敏感用户身份
     *
     * @param suiteToken 第三方企业应用凭证
     **/
    UserDetailResDto userInfo(SuiteAccessonReqDto suiteToken, UserDetailReqDto userDetailReqDto);

    /**
     * 获取应用的管理员列表
     *
     * @param suiteToken 第三方应用凭证
     * @param adminReqDto 入参Dto
     **/
    AdminResListDto adminList(SuiteAccessonReqDto suiteToken, AdminReqDto adminReqDto);

    /**
     * 获取部门成员详情
     **/
    OrgUserDetailResDto orgUserDetail(OrgUserReqDto orgUserReqDto);

    /**
     * 获取部门成员
     **/
    OrgUserResDto orgUserList(OrgUserReqDto orgUserReqDto);

    /**
     * 读取成员
     **/
    ReadUserInfoResDto readUserInfo(UserReqDto userReqDto);

}

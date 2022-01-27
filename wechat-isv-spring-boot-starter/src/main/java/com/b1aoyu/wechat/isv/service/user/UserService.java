package com.b1aoyu.wechat.isv.service.user;

import org.springframework.stereotype.Service;
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
import com.b1aoyu.wechat.isv.utils.WechatCommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author z1aoyu 2022-01-06
 **/
@Slf4j
@Service
public class UserService implements IUserService {

    /**
     * 用户Oauth2授权链接
     **/
    @Override
    public String userOauthURL(UserOauthReqDto userOauthReqDto) {
        return WechatCommonUtil.userOauthURL(userOauthReqDto);
    }


    /**
     * 获取访问用户身份
     *
     * @param userCode 通过成员授权获取到的code，最大为512字节。每次成员授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
     **/
    @Override
    public UserInfoResDto userInfo(SuiteAccessonReqDto suiteToken, String userCode) {
        return WechatCommonUtil.userInfo(suiteToken.getSuiteToken(), userCode);
    }

    /**
     * 获取企业授权信息
     **/
    @Override
    public UserDetailResDto userInfo(SuiteAccessonReqDto suiteToken, UserDetailReqDto userDetailReqDto) {
        return WechatCommonUtil.userInfo(suiteToken.getSuiteToken(), userDetailReqDto);
    }

    /**
     * 获取应用的管理员列表
     **/
    @Override
    public AdminResListDto adminList(SuiteAccessonReqDto suiteToken, AdminReqDto adminReqDto) {
        return WechatCommonUtil.adminList(suiteToken.getSuiteToken(), adminReqDto);
    }

    /**
     * 获取部门成员详情
     **/
    @Override
    public OrgUserDetailResDto orgUserDetail(OrgUserReqDto orgUserReqDto) {
        return WechatCommonUtil.orgUserDetail(orgUserReqDto);
    }

    /**
     * 获取部门成员
     **/
    @Override
    public OrgUserResDto orgUserList(OrgUserReqDto orgUserReqDto) {
        return WechatCommonUtil.orgUserList(orgUserReqDto);
    }

    /**
     * 读取成员
     **/
    @Override
    public ReadUserInfoResDto readUserInfo(UserReqDto userReqDto) {
        return WechatCommonUtil.readUserInfo(userReqDto);
    }

}

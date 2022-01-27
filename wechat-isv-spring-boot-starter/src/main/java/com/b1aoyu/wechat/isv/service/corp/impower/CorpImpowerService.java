package com.b1aoyu.wechat.isv.service.corp.impower;

import org.springframework.stereotype.Service;
import com.b1aoyu.wechat.isv.bean.dto.SuiteAccessonReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.CorpInstallReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.SessionSettingReqDto;
import com.b1aoyu.wechat.isv.bean.dto.res.PreAuthorizationResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.SessionSettingResDto;
import com.b1aoyu.wechat.isv.utils.WechatCommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author：z1aoyu 2022-01-07
 * @description:企业授权
 */
@Service
@Slf4j
public class CorpImpowerService implements ICorpImpowerService {
//
//    //第三方企业Id
//    private String corpId;
//
//    //密令
//    private String token;
//
//    //密钥
//    private String aesKey;
//
//    //密钥
//    private String userOauthUrl;
//
//    //密钥
//    private String corpOauthUrl;
//
//
//    public CorpImpowerService(WechatProperties wechatProperties) {
//        this.corpId = wechatProperties.getCorpId();
//        this.token = wechatProperties.getToken();
//        this.aesKey = wechatProperties.getAesKey();
//        this.userOauthUrl = wechatProperties.getUserOauthUrl();
//        this.corpOauthUrl = wechatProperties.getCorpOauthUrl();
//    }

    /**
     * 获取企业预授权码 用于构造企业授权安装链接（需要完成授权设置）
     **/
    @Override
    public PreAuthorizationResDto preAuthCode(SuiteAccessonReqDto suiteAccessonReqDto) {
        return WechatCommonUtil.preAuthCode(suiteAccessonReqDto.getSuiteToken());
    }

    /**
     * 设置授权配置
     **/
    @Override
    public SessionSettingResDto sessionSetting(SuiteAccessonReqDto suiteAccessonReqDto, SessionSettingReqDto sessionSettingReqDto) {
        return WechatCommonUtil.sessionSetting(suiteAccessonReqDto.getSuiteToken(), sessionSettingReqDto);
    }

    /**
     * 获取企业授权安装链接
     **/
    @Override
    public String corpInstall(CorpInstallReqDto corpInstallReqDto) {
        return WechatCommonUtil.corpInstall(corpInstallReqDto);
    }

}

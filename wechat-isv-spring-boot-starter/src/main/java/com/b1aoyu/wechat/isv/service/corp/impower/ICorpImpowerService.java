package com.b1aoyu.wechat.isv.service.corp.impower;


import com.b1aoyu.wechat.isv.bean.dto.SuiteAccessonReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.CorpInstallReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.SessionSettingReqDto;
import com.b1aoyu.wechat.isv.bean.dto.res.PreAuthorizationResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.SessionSettingResDto;

/**
 * @author：z1aoyu 2022-01-07
 * @description:企业授权
 */
public interface ICorpImpowerService {

    /**
     * 获取企业预授权码 用于构造企业授权安装链接（需要完成授权设置）
     **/
    PreAuthorizationResDto preAuthCode(SuiteAccessonReqDto suiteAccessonReqDto);

    /**
     * 设置授权配置
     **/
    SessionSettingResDto sessionSetting(SuiteAccessonReqDto suiteAccessonReqDto, SessionSettingReqDto sessionSettingReqDto);

    /**
     * 获取企业授权安装链接
     **/
    String corpInstall(CorpInstallReqDto corpInstallReqDto);

}

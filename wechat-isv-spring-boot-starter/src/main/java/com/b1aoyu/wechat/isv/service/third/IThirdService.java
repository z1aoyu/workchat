package com.b1aoyu.wechat.isv.service.third;


import com.b1aoyu.wechat.isv.bean.dto.req.AppInfoReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.SuiteTokenReqDto;
import com.b1aoyu.wechat.isv.bean.dto.res.AppInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.SuiteTokenResDto;

/**
 * @author z1aoyu 2022-01-06
 **/
public interface IThirdService {

    /**
     * 获取第三方应用凭证
     **/
    SuiteTokenResDto suiteToken(SuiteTokenReqDto suiteTokenReqDto);

    /**
     * 获取应用详情信息
     **/
    AppInfoResDto appInfo(AppInfoReqDto appInfoReqDto);

}

package com.b1aoyu.wechat.isv.service.third;

import org.springframework.stereotype.Service;
import com.b1aoyu.wechat.isv.bean.dto.req.AppInfoReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.SuiteTokenReqDto;
import com.b1aoyu.wechat.isv.bean.dto.res.AppInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.SuiteTokenResDto;
import com.b1aoyu.wechat.isv.utils.WechatCommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author z1aoyu 2022-01-06
 **/
@Slf4j
@Service
public class ThirdService implements IThirdService {


    /**
     * 获取第三方应用凭证
     **/
    @Override
    public SuiteTokenResDto suiteToken(SuiteTokenReqDto suiteTokenReqDto) {
        return WechatCommonUtil.getSuiteToken(suiteTokenReqDto);
    }

    /**
     * 获取应用详情
     **/
    @Override
    public AppInfoResDto appInfo(AppInfoReqDto appInfoReqDto) {
        return WechatCommonUtil.appInfo(appInfoReqDto);
    }

}

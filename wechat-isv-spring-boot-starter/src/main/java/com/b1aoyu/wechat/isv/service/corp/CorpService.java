package com.b1aoyu.wechat.isv.service.corp;

import org.springframework.stereotype.Service;
import com.b1aoyu.wechat.isv.bean.dto.SuiteAccessonReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.AuthorizationInfoReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.CommonReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.OrgReqDto;
import com.b1aoyu.wechat.isv.bean.dto.req.PermanentCodeReqDto;
import com.b1aoyu.wechat.isv.bean.dto.res.AccessTokenResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.TicketDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.authorizationinfo.AuthorizationInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.org.OrgInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.org.SingleOrgInfoResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.org.SubordinateOrgResDto;
import com.b1aoyu.wechat.isv.bean.dto.res.corp.permanentcode.PermanentCodeResDto;
import com.b1aoyu.wechat.isv.utils.WechatCommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author z1aoyu 2022-01-06
 **/
@Slf4j
@Service
public class CorpService implements ICorpService {

    /**
     * 获取企业凭证
     **/
    @Override
    public AccessTokenResDto update(SuiteAccessonReqDto suiteToken, CommonReqDto commonReqDto) {
        return WechatCommonUtil.getAccessToken(suiteToken.getSuiteToken(), commonReqDto);
    }

    /**
     * 获取企业永久授权码
     **/
    @Override
    public PermanentCodeResDto permanentCode(SuiteAccessonReqDto suiteToken, PermanentCodeReqDto permanentCodeReqDto) {
        return WechatCommonUtil.permanentCode(suiteToken.getSuiteToken(), permanentCodeReqDto);
    }

    /**
     * 获取企业授权信息
     **/
    @Override
    public AuthorizationInfoResDto authorizationInfo(SuiteAccessonReqDto suiteToken, AuthorizationInfoReqDto authorizationInfoReqDtoa) {
        return WechatCommonUtil.authorizationInfo(suiteToken.getSuiteToken(), authorizationInfoReqDtoa);

    }

    /**
     * 获取企业凭证
     **/
    @Override
    public AccessTokenResDto getAccessToken(SuiteAccessonReqDto suiteToken, CommonReqDto commonReqDto) {
        AccessTokenResDto accessToken = WechatCommonUtil.getAccessToken(suiteToken.getSuiteToken(), commonReqDto);
        return accessToken;
    }

    /**
     * 获取部门列表
     **/
    @Override
    public OrgInfoResDto orgInfoResDto(OrgReqDto orgReqDto) {
        return WechatCommonUtil.orgURL(orgReqDto);
    }

    /**
     * 获取子部门列表
     **/
    @Override
    public SubordinateOrgResDto subordinateOrgList(OrgReqDto orgReqDto) {
        return WechatCommonUtil.subordinateOrgURL(orgReqDto);
    }

    /**
     * 获取单个部门
     **/
    @Override
    public SingleOrgInfoResDto singleOrg(OrgReqDto orgReqDto) {
        return WechatCommonUtil.singleOrgURL(orgReqDto);
    }

    /**
     * 获取企业的jsapi_ticket
     **/
    @Override
    public TicketDto getJsAPITicket(String accessToken) {
        return WechatCommonUtil.getJsAPITicket(accessToken);
    }

    /**
     * 获取应用的jsapi_ticket
     **/
    @Override
    public TicketDto getAgentTicket(String accessToken) {
        return WechatCommonUtil.getAgentTicket(accessToken);
    }

}

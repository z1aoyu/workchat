package com.b1aoyu.wechat.isv.service.corp;


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

/**
 * @author z1aoyu 2022-01-06
 **/
public interface ICorpService {


    /**
     * 获取企业AccessToken信息
     *
     * @param suiteToken 第三方应用凭证
     * @param commonReqDto 公共参数对象
     **/
    AccessTokenResDto update(SuiteAccessonReqDto suiteToken, CommonReqDto commonReqDto);

    /**
     * 获取企业永久授权码
     **/
    PermanentCodeResDto permanentCode(SuiteAccessonReqDto suiteToken, PermanentCodeReqDto permanentCodeReqDto);

    /**
     * 获取企业授权信息
     **/
    AuthorizationInfoResDto authorizationInfo(SuiteAccessonReqDto suiteToken, AuthorizationInfoReqDto authorizationInfoReqDtoa);

    /**
     * 获取企业凭证
     *
     * @param suiteToken 第三方应用凭证
     * @param commonReqDto 公共入参
     **/
    AccessTokenResDto getAccessToken(SuiteAccessonReqDto suiteToken, CommonReqDto commonReqDto);






    /**
     * 获取部门列表
     **/
    OrgInfoResDto orgInfoResDto(OrgReqDto orgReqDto);

    /**
     * 获取子部门列表
     **/
    SubordinateOrgResDto subordinateOrgList(OrgReqDto orgReqDto);

    /**
     * 获取单个部门
     **/
    SingleOrgInfoResDto singleOrg(OrgReqDto orgReqDto);



    /**
     * 获取企业的jsapi_ticket
     **/
    TicketDto getJsAPITicket(String accessToken);

    /**
     * 获取应用的jsapi_ticket
     **/
    TicketDto getAgentTicket(String accessToken);



}

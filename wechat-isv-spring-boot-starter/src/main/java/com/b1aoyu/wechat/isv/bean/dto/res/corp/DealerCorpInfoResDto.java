package com.b1aoyu.wechat.isv.bean.dto.res.corp;

import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:代理服务商企业信息。应用被代理后才有该信息
 */
@Data
public class DealerCorpInfoResDto {

    /**
     * 代理服务商企业微信id
     **/
    private String corpid;

    /**
     * 代理服务商企业微信名称
     **/
    private String corp_name;

}

package com.b1aoyu.wechat.isv.bean.dto.res.corp;

import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:共享了应用的企业信息，仅当由企业互联或者上下游共享应用触发的安装时才返回
 */
@Data
public class SharedFromResDto {

    /**
     * 共享了应用的企业信息，仅当企业互联或者上下游共享应用触发的安装时才返回
     **/
    private String corpid;

    /**
     * 共享了途径，0表示企业互联，1表示上下游
     **/
    private String share_type;

}

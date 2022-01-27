package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author z1aoyu 2022-01-06
 **/
@Data
public class AdminReqDto {

    /**
     * 授权方corpid
     **/
    @NotNull
    private String auth_corpid;

    /**
     * 授权方安装的应用agentid
     **/
    @NotNull
    private String agentid;

}

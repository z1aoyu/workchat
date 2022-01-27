package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-10
 * @description:应用详情查询
 */
@Data
public class AppInfoReqDto {

    /**
     * 调用接口凭证
     **/
    @NotNull
    private String access_token;

    /**
     * 企业安装成功后生成的应用id
     **/
    @NotNull
    private String agentid;

}

package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-11
 * @description: 获取部门相关信息的ReqDto
 */
@Data
public class OrgReqDto {

    /**
     * 调用接口凭证
     **/
    @NotNull
    private String access_token;

    /**
     * 部门id。获取指定部门及其下的子部门（以及子部门的子部门等等，递归）。 如果为空字符串，默认获取全量组织架构
     **/
    @NotNull
    private String id = "";

}

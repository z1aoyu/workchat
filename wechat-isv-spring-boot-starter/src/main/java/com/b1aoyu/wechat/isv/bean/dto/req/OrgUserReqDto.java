package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-11
 * @description: 查询用户信息DTO
 */
@Data
public class OrgUserReqDto {

    /**
     * 调用接口凭证
     **/
    @NotNull
    private String accessToken;

    /**
     * 获取的部门id
     **/
    @NotNull
    private String departmentId;

    /**
     * 1/0：是否递归获取子部门下面的成员
     **/
    @NotNull
    private String fetchChild;

}

package com.b1aoyu.wechat.isv.bean.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description: 第三方应用凭证
 */
@Data
public class SuiteAccessonReqDto {

    /**
     * 第三方应用凭证
     **/
    @NotNull
    private String suiteToken;

}

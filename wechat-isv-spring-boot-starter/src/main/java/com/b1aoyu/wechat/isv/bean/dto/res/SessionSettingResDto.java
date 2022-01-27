package com.b1aoyu.wechat.isv.bean.dto.res;

import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:授权设置
 */
@Data
public class SessionSettingResDto {

    /**
     * 错误码，0表示正常返回，可读取admin的管理员列表
     **/
    private String errcode;

    /**
     * 对返回码的文本描述内容
     **/
    private String errmsg;

}

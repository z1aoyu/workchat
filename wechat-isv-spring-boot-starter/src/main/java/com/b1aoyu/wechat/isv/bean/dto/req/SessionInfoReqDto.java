package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:授权过程中需要用到的会话信息
 */
@Data
public class SessionInfoReqDto {

    /**
     * 授权类型：0 正式授权， 1 测试授权。 默认值为0。注意，请确保应用在正式发布后的授权类型为“正式授权”
     **/
    @NotNull
    private String auth_type;

}

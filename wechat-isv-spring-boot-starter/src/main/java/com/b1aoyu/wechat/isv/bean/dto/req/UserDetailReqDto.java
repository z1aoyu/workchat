package com.b1aoyu.wechat.isv.bean.dto.req;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:获取访问用户敏感信息
 */
@Data
public class UserDetailReqDto {

    /**
     * 成员票据
     **/
    @NotNull
    private String user_ticket;

}

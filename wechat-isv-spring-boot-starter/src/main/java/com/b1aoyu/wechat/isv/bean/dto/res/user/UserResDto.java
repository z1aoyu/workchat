package com.b1aoyu.wechat.isv.bean.dto.res.user;

import java.util.List;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-11
 * @description: 授权范围可见的用户信息
 */
@Data
public class UserResDto {

    /**
     * 企业应用可见范围（人员），其中包括userid
     **/
    private List<UserIdResDto> user;

}

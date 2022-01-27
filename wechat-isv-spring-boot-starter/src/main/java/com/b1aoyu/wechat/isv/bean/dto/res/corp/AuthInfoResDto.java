package com.b1aoyu.wechat.isv.bean.dto.res.corp;

import java.util.List;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-07
 * @description:授权信息DTO。如果是通讯录应用，且没开启实体应用，是没有该项的。通讯录应用拥有企业通讯录的全部信息读写权限
 */
@Data
public class AuthInfoResDto {

    /**
     * 授权的应用信息，注意是一个数组，但仅旧的多应用套件授权时会返回多个agent，对新的单应用授权，永远只返回一个agent
     **/
    private List<AgentInfoResDto> agent;

}

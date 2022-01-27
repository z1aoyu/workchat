package com.b1aoyu.wechat.isv.bean.dto.res.corp.org;

import java.util.List;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-11
 * @description: 应用可见范围内的部门id
 */
@Data
public class OrgResDto {

    /**
     * 部门Id集合
     **/
    private List<String> partyid;

}

package com.b1aoyu.wechat.isv.bean.dto.res.corp.org;

import lombok.Data;

/**
 * @author：z1aoyu 2022-01-11
 * @description: 获取子部门时的部门详细信息
 */
@Data
public class SimpleOrgResDto {
    /**
     * 创建的部门id
     **/
    private String id;

    /**
     * 父部门id。根部门为1
     **/
    private String parentid;

    /**
     * 在父部门中的次序值。order值大的排序靠前。值范围是[0, 2^32)
     **/
    private String order;

}

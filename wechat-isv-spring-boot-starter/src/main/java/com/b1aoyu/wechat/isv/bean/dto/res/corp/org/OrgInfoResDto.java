package com.b1aoyu.wechat.isv.bean.dto.res.corp.org;

import java.util.List;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-11
 * @description:部门详情
 */
@Data
public class OrgInfoResDto {

    /**
     * 错误码，0表示正常返回，可读取admin的管理员列表
     **/
    private String errcode;

    /**
     * 对返回码的文本描述内容
     **/
    private String errmsg;

    /**
     * 	部门列表数据
     **/
    private List<OrgMessagesResDto> department;


}

package com.b1aoyu.wechat.isv.bean.dto.res.user;

import java.util.List;
import com.b1aoyu.wechat.isv.bean.bo.OrgUserInfoBo;
import lombok.Data;

/**
 * @author：z1aoyu 2022-01-11
 * @description:部门内成员
 */
@Data
public class OrgUserResDto {

    /**
     * 错误码，0表示正常返回，可读取admin的管理员列表
     **/
    private String errcode;

    /**
     * 对返回码的文本描述内容
     **/
    private String errmsg;

    /**
     * 成员UserID。对应管理端的帐号，企业内必须唯一。不区分大小写，长度为1~64个字节
     **/
    private List<OrgUserInfoBo> userlist;

}

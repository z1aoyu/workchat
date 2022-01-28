package com.b1aoyu.workchat.application.logic.data;

import org.springframework.beans.factory.InitializingBean;
import cn.hutool.json.JSONObject;

/**
 * 数据回调处理策略
 */
public interface DataHandler extends InitializingBean {

    public void execute(JSONObject jsonObject);

}
package com.b1aoyu.workchat.application.logic.order;

import cn.hutool.json.JSONObject;

/**
 * 指令策略
 */
public interface OrderHandler {

    public void execute(JSONObject jsonObject);

}
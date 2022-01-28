package com.b1aoyu.workchat.application.logic.order.handle.share;

import org.springframework.stereotype.Component;
import com.b1aoyu.workchat.application.beans.enums.EnterpriseLicenseEnum;
import com.b1aoyu.workchat.application.logic.order.OrderHandler;
import com.b1aoyu.workchat.application.logic.order.annotation.OrderStrategyMode;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author z1aoyu 2022-01-28
 **/
@Slf4j
@Component("shareUpDownHandler")
@OrderStrategyMode(OrderModel = EnterpriseLicenseEnum.SHARE_CHAIN_CHANGE)
public class ShareUpDownHandler implements OrderHandler {

    @Override
    public void execute(JSONObject jsonObject) {
        log.info("执行解析上下游共享应用事件回调指令拿到对象:{}", jsonObject);
    }

}
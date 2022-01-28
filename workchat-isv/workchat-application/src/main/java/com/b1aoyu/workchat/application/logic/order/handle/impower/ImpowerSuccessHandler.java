package com.b1aoyu.workchat.application.logic.order.handle.impower;

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
@Component("impowerSuccessHandler")
@OrderStrategyMode(OrderModel = EnterpriseLicenseEnum.CREATE_AUTH)
public class ImpowerSuccessHandler implements OrderHandler {

    @Override
    public void execute(JSONObject jsonObject) {
        log.info("执行解授权成功通知通知指令拿到对象:{}", jsonObject);
    }

}
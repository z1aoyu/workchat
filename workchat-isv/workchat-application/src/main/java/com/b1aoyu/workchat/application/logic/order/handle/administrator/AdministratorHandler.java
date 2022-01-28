package com.b1aoyu.workchat.application.logic.order.handle.administrator;

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
@Component("administratorHandler")
@OrderStrategyMode(OrderModel = EnterpriseLicenseEnum.CHANGE_APP_ADMIN)
public class AdministratorHandler implements OrderHandler {

    @Override
    public void execute(JSONObject jsonObject) {
        log.info("执行解析应用管理员变更通知指令拿到对象:{}", jsonObject);
    }

}
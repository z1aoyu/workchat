package com.b1aoyu.workchat.application.logic.order.handle.org;

import org.springframework.stereotype.Component;
import com.b1aoyu.workchat.application.beans.enums.EnterpriseLicenseEnum;
import com.b1aoyu.workchat.application.logic.order.OrderHandler;
import com.b1aoyu.workchat.application.logic.order.annotation.OrderStrategyMode;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author z1aoyu 2022-01-28
 **/
@Component("orgUpdateHandler")
@OrderStrategyMode(OrderModel = EnterpriseLicenseEnum.UPDATE_PARTY)
@Slf4j
public class OrgUpdateHandler implements OrderHandler {

    @Override
    public void execute(JSONObject jsonObject) {
        log.info("执行解析部门更新指令拿到对象:{}", jsonObject);
    }

}
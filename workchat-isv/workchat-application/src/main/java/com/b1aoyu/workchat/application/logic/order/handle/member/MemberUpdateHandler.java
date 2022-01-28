package com.b1aoyu.workchat.application.logic.order.handle.member;

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
@Component("memberUpdateHandler")
@OrderStrategyMode(OrderModel = EnterpriseLicenseEnum.UPDATE_USER)
public class MemberUpdateHandler implements OrderHandler {

    @Override
    public void execute(JSONObject jsonObject) {
        log.info("执行解析成员创建指令拿到对象:{}", jsonObject);
    }

}
package com.b1aoyu.workchat.application.logic.order;

import org.springframework.stereotype.Service;
import com.b1aoyu.workchat.application.beans.enums.EnterpriseLicenseEnum;


/**
 * @author：z1aoyu 2022-01-28
 * @description:指令工厂
 */
@Service
public class OrderFactory extends OrderFactoryConfig {

    public static OrderHandler getInvokeStrategy(EnterpriseLicenseEnum enterpriseLicenseEnum) {
        return strategyMap.get(enterpriseLicenseEnum.getCode());
    }

}

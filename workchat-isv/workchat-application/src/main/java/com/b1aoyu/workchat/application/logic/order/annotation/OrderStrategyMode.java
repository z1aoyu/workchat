package com.b1aoyu.workchat.application.logic.order.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.b1aoyu.workchat.application.beans.enums.EnterpriseLicenseEnum;

/**
 * @author：z1aoyu 2022-01-28
 * @description: 指令事件模型注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderStrategyMode {

    /**
     * 指令事件策略模型
     **/
    EnterpriseLicenseEnum OrderModel();

}

package com.b1aoyu.workchat.application.logic.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ObjectUtils;
import com.b1aoyu.workchat.application.logic.order.annotation.OrderStrategyMode;

/**
 * 指令工厂配置
 **/
public class OrderFactoryConfig {

    protected static final Map<String, OrderHandler> strategyMap = new HashMap<>();

    @Resource
    private final List<OrderHandler> handlerList = new ArrayList<>();

    @PostConstruct
    public void init() {
        handlerList.forEach(handler -> {
            OrderStrategyMode orderStrategyMode = AnnotationUtils.findAnnotation(handler.getClass(), OrderStrategyMode.class);
            if (!ObjectUtils.isEmpty(orderStrategyMode)) {
                strategyMap.put(orderStrategyMode.OrderModel().getCode(), handler);
            }
        });
    }

}

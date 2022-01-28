package com.b1aoyu.workchat.application.logic.data;

import java.util.HashMap;
import java.util.Map;
import org.springframework.util.StringUtils;
import com.b1aoyu.workchat.application.beans.enums.EnterpriseDataEnum;

/**
 * 数据回调工厂
 **/
public class DataFactory {

    private static Map<String, DataHandler> strategyMap = new HashMap<>();

    public static DataHandler getInvokeStrategy(EnterpriseDataEnum enterpriseDataEnum) {
        return strategyMap.get(enterpriseDataEnum.getCode());
    }

    public static void register(String name, DataHandler handler) {
        if (StringUtils.isEmpty(name) || null == handler) {
            return;
        }
        strategyMap.put(name, handler);
    }

}

package com.b1aoyu.workchat.application.logic.data.handle;

import org.springframework.stereotype.Component;
import com.b1aoyu.workchat.application.beans.enums.EnterpriseDataEnum;
import com.b1aoyu.workchat.application.logic.data.DataFactory;
import com.b1aoyu.workchat.application.logic.data.DataHandler;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author：z1aoyu 2022-01-28
 * @description:
 */
@Component
@Slf4j
public class EventAgainHandle implements DataHandler {

    @Override
    public void execute(JSONObject jsonObject) {
        log.info("执行成员进入应用事件拿到对象:{}", jsonObject);
    }

    @Override
    public void afterPropertiesSet() {
        DataFactory.register(EnterpriseDataEnum.ENTER_AGENT.getCode(), this);
    }

}

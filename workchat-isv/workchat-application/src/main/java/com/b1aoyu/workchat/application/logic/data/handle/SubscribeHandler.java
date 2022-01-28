package com.b1aoyu.workchat.application.logic.data.handle;

import org.springframework.stereotype.Component;
import com.b1aoyu.workchat.application.beans.bo.CreateAppUserBo;
import com.b1aoyu.workchat.application.beans.enums.EnterpriseDataEnum;
import com.b1aoyu.workchat.application.logic.data.DataFactory;
import com.b1aoyu.workchat.application.logic.data.DataHandler;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author z1aoyu 2022-01-28
 **/
@Component
@Slf4j
public class SubscribeHandler implements DataHandler {

    @Override
    public void execute(JSONObject jsonObject) {
        CreateAppUserBo createAppUserBo = jsonObject.toBean(CreateAppUserBo.class);
        log.info("执行解析应用订阅事件拿到对象:{}", createAppUserBo);
    }

    @Override
    public void afterPropertiesSet() {
        DataFactory.register(EnterpriseDataEnum.SUBSCRIBE.getCode(), this);
    }

}
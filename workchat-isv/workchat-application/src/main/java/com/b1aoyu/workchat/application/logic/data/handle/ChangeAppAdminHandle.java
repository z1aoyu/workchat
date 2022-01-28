package com.b1aoyu.workchat.application.logic.data.handle;

import org.springframework.stereotype.Component;
import com.b1aoyu.workchat.application.beans.enums.EnterpriseDataEnum;
import com.b1aoyu.workchat.application.logic.data.DataFactory;
import com.b1aoyu.workchat.application.logic.data.DataHandler;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author：z1aoyu 2022-01-28
 * @description:授权变更事件
 */
@Component
@Slf4j
public class ChangeAppAdminHandle implements DataHandler {

    @Override
    public void execute(JSONObject jsonObject) {
        log.info("执行授权变更事件拿到对象:{}", jsonObject);
    }

    @Override
    public void afterPropertiesSet() {
        DataFactory.register(EnterpriseDataEnum.CHANGE_APP_ADMIN.getCode(), this);
    }

}

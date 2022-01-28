package com.b1aoyu.workchat.common.mq.producer;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author：z1aoyu 2022-01-28
 * @description:RabbitMq发送
 */
@Component
public class RabbitProducer {

    private Logger logger = LoggerFactory.getLogger(RabbitProducer.class);

    @Resource
    private RabbitTemplate rabbitTemplate;

}

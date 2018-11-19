package com.corn.productordemo.service;

import com.corn.commondemo.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: suyiming
 * @Date: 18-11-19 23:02
 * @Description:
 */

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Order order) throws Exception{
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getId());

        rabbitTemplate.convertAndSend(
                "order-exchange",//交换机
                "order.1234",//路由键
                order,//消息内容
                correlationData//消息唯一ID
        );

    }
}

package com.corn.consumerdemo.service.fanout;

import com.corn.commondemo.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @Auther: suyiming
 * @Date: 18-11-19 23:38
 * @Description:
 */

@Component
public class OrderRecieverFanout {

    //配置监听队列 fanout 将消息投递到所有绑定到改交换机的所有队列（routing-key 无作用）
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-queue-fanout1",durable = "true"),
            exchange = @Exchange(value = "order-exchange-fanout",durable = "true",type = "fanout"))
            //key = "order.*"
    )


    @RabbitHandler//监听处理
    public void onOrderMessage(@Payload Order order,//消息的内容
                               @Headers Map<String,Object> headers,//消息属性
                               Channel channel) throws IOException {//手工签收需要调用channel
        System.out.println("---------order-queue-fanout1收到消息-----------");
        System.out.println("订单id"+order.getId());
        System.out.println("订单名称"+order.getName());
        System.out.println("消息ID"+order.getMessageId());

        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //手动签收,响应mq签收成功
        channel.basicAck(deliveryTag,false);//false不支持批量签收

    }
}

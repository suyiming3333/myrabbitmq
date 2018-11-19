package com.corn.productordemo;

import com.corn.commondemo.entity.Order;
import com.corn.productordemo.service.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductorDemoApplicationTests {

    @Autowired
    private OrderSender orderSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSend() throws Exception{
        orderSender.send(new Order("1","1stOrder",System.currentTimeMillis()+"#"+ UUID.randomUUID()));
    }

}

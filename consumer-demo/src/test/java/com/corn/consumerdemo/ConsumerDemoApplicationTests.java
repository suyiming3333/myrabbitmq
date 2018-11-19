package com.corn.consumerdemo;

import com.corn.consumerdemo.service.OrderReciever;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerDemoApplicationTests {

    @Autowired
    private OrderReciever orderReciever;

    @Test
    public void contextLoads() {
    }

}

package com.curry.studymq;

import com.curry.studymq.Producer.MqProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMq {
    @Autowired
    private MqProducer helloSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

}

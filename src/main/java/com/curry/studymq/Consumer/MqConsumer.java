package com.curry.studymq.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")
public class MqConsumer {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("topic.message Receiver  : " + hello);
    }
}

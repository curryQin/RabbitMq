package com.curry.studymq.Producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MqProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        //发送一个路由key为topic.messages的消息，此消息只会被投递到对应的Binding key上
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", "topic.messages 消息");
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", "topic.message 消息");
    }
}

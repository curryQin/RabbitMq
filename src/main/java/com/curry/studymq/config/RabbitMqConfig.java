package com.curry.studymq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    final static String message = "topic.message";
    final static String messages = "topic.messages";
    //声明两个queue
    @Bean("queueMessage")
    public Queue message() {
        return new Queue(message);
    }

    @Bean("queueMessages")
    public Queue messages() {
        return new Queue(messages);
    }

    //创建一个topic策略的交换机
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    //将队列绑定到交换机上
    @Bean
    public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.message");
    }

    @Bean
    public Binding bindingExchangeMessages(Queue queueMessages, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMessages).to(topicExchange).with("topic.#");
    }

}

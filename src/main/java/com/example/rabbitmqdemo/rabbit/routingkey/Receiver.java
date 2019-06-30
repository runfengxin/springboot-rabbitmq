package com.example.rabbitmqdemo.rabbit.routingkey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver{
    private static Logger logger = LoggerFactory.getLogger(Receiver.class);

    //注解很重要，标注了exchange、routingkey、queue之间的关系，对应指定到这个queue
    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "${qf}"),
            exchange = @Exchange(value = "exchange.ff.ff.sendPush"), key = "routingkey.ff.ff.sendPush")})
    public void receiver(String message) {
        logger.info("sendPush接收消息:{}", message);
    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "123"),
            exchange = @Exchange(value = "exchange.ff.ff.aaa"), key = "sendPush111")})
    public void receiverResp(String message) {
        logger.info("sendPush111接收消息:{}", message);
    }

}
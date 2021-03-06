package com.example.rabbitmqdemo.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {

//    @RabbitHandler
//    public void process(String message) {
//        System.out.println("fanout Receiver A  : " + message);
//    }

    @RabbitHandler
    public String process(String message) {
        String s = "fanout Receiver A  : " + message;
        System.out.println(s);
        return s;
    }

}

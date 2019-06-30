package com.example.rabbitmqdemo.rabbitmq;

import com.example.rabbitmqdemo.rabbit.routingkey.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoutingKeyTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Sender sender;

    @Test
    public void send(){
        String content = "Date:" + new Date();
//        amqpTemplate.convertAndSend("couponSend",content);
        rabbitTemplate.convertAndSend("exchange.ff.ff.sendPush", "routingkey.ff.ff.sendPush", "test:" + content);
    }


//    @Test
//    public void sendSync(){
//        String content = "Date:" + new Date();
//        Object result=rabbitTemplate.convertSendAndReceive("exchange.ff.ff.sendPush", "routingkey.ff.ff.sendPushResp", "test:" + content);
//        System.out.println(result);
//    }

    @Test
    public void sendSync(){
        String content = "Date:" + new Date();
        sender.send(content);
    }
}

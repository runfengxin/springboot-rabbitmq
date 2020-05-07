package com.example.rabbitmqdemo.rabbit.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hi, fanout msg ";
		System.out.println("Sender : " + context);
//		this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
		Object fanoutExchange = this.rabbitTemplate.convertSendAndReceive("fanoutExchange", "", context);
		System.out.println(fanoutExchange);
	}

}
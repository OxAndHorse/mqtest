package com.example.mqproducer.service;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MessageProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @PostConstruct
    public void init() {
        System.out.println("[RocketMQ Producer] 初始化完成，连接成功！");
    }

    public void sendCounterMessage() {
        rocketMQTemplate.convertAndSend("counter-topic", "increment");
    }
}

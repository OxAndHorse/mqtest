package com.example.mqconsumer.consumer;

import com.example.mqconsumer.entity.CounterEntity;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.mqconsumer.repository.CounterRepository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Optional;

@Component
@RocketMQMessageListener(
        topic = "counter-topic",
        consumerGroup = "counter-consumer-group"
)
public class MessageConsumer implements RocketMQListener<String> {

    @Autowired
    private CounterRepository counterRepository;

    @PostConstruct
    public void onInit() {
        System.out.println("[RocketMQ Consumer] 启动成功，已连接并监听 topic：counter-topic");
    }

    @Override
    @Transactional
    public void onMessage(String message) {
        try {
            // 获取 ID=1 的记录
            Optional<CounterEntity> optional = counterRepository.findById(1);

            if (optional.isPresent()) {
                CounterEntity entity = optional.get();

                // +1 操作
                entity.setTotalCount(entity.getTotalCount() + 1);

                // 保存更新
                counterRepository.save(entity);

                System.out.println("Counter updated: " + entity.getTotalCount());
            } else {
                System.err.println("Counter with ID=1 not found!");
            }

        } catch (Exception e) {
            System.err.println("Error processing message: " + message);
            e.printStackTrace();
        }
    }

}

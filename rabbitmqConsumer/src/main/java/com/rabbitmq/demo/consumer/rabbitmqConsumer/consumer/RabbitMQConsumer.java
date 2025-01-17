package com.rabbitmq.demo.consumer.rabbitmqConsumer.consumer;

import com.rabbitmq.demo.consumer.rabbitmqConsumer.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(String message) {
        LOGGER.info(String.format("Consumed Message -> %s", message));
    }

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void jsonConsumer(User user) {
        LOGGER.info(String.format("Consumed Json Message -> %s", user.toString()));
    }
}

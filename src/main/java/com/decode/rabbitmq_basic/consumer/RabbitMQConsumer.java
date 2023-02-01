package com.decode.rabbitmq_basic.consumer;

import com.decode.rabbitmq_basic.dto.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message) {
        log.info("This is received message:" + message);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(PersonDto personDto) {
        log.info("This is received message:" + personDto);
    }
}

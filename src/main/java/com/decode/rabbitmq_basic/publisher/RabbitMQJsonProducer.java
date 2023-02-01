package com.decode.rabbitmq_basic.publisher;

import com.decode.rabbitmq_basic.dto.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonProducer {

    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routingKey.json.name}")
    private String routingKeyJson;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(PersonDto personDto) {
        log.info("Sending json object..... ");
        rabbitTemplate.convertAndSend(exchange, routingKeyJson, personDto);
    }
}

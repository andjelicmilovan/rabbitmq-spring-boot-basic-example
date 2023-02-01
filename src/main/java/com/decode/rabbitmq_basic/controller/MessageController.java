package com.decode.rabbitmq_basic.controller;

import com.decode.rabbitmq_basic.dto.PersonDto;
import com.decode.rabbitmq_basic.publisher.RabbitMQJsonProducer;
import com.decode.rabbitmq_basic.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;
    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer, RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @PostMapping()
    public ResponseEntity<String> sendMessage() {
        rabbitMQProducer.sendMessage("This is test message");
        return ResponseEntity.ok("Message successfully sent to queue");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendMessageJson() {
        PersonDto personDto = new PersonDto();
        personDto.setId(1134);
        personDto.setFirstName("Mari");
        personDto.setLastName("Bus");
        rabbitMQJsonProducer.sendMessage(personDto);
        return ResponseEntity.ok("Message successfully sent to queue");
    }
}

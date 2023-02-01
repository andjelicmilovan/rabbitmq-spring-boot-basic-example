package com.decode.rabbitmq_basic.controller;

import com.decode.rabbitmq_basic.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @PostMapping()
    public ResponseEntity<String> sendMessage() {
        rabbitMQProducer.sendMessage("This is test message");
        return ResponseEntity.ok("Message successfully sent to queue");
    }
}

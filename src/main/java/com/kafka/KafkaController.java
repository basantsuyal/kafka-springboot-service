package com.kafka;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.producer.Producer;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    public KafkaController(Producer producer) {
	this.producer = producer;
    }

    org.slf4j.Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam String message) {
	logger.info("received request to send message to kafka topic as : " + message);
	this.producer.sendMessage(message);
    }
}

package com.example.spring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KafkaController(
    private val kafkaProducer: KafkaProducer
) {

    @GetMapping("/kafka")
    fun kafka(): String {
        kafkaProducer.kafkaTemplate().send("test-events", "Hello, Kafka!")
        return "Message sent to the Kafka Topic test Successfully"
    }
}

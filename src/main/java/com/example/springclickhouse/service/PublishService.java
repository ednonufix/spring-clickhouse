package com.example.springclickhouse.service;

import com.example.springclickhouse.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PublishService {

    @Value("${kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void publish(User user) {
        kafkaTemplate.send(topic, user.id(), user);
    }

}

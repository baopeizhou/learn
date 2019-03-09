package org.bob.learn.client.service.impl;

import org.bob.learn.client.common.dto.Message;
import org.bob.learn.client.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class MessageProducerServiceImpl implements MessageProducerService {


    @Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate;

    @Override
    public void send(Message message) {
        kafkaTemplate.send("learn",message);
        kafkaTemplate.send
    }
}

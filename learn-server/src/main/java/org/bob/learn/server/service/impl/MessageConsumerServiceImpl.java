package org.bob.learn.server.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.bob.learn.client.common.dto.Message;
import org.bob.learn.client.service.MessageConsumerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageConsumerServiceImpl implements MessageConsumerService {

    @KafkaListener(id = "1",topics = "learn")
    @Override
    public void receive(Message message) {
        log.info(String.valueOf(message));
    }
}

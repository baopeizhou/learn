package org.bob.learn.server.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.bob.learn.server.service.MessageTopic;
import org.bob.learn.server.service.StreamConsumerService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding(value = MessageTopic.class)
public class StreamConsumerServiceImpl implements StreamConsumerService {


    @Override
    @StreamListener(MessageTopic.COMMAND)
    public void consume(Object message) {
        log.info(String.valueOf(message));
    }
}

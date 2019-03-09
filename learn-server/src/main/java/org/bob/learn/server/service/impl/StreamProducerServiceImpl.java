package org.bob.learn.server.service.impl;


import org.bob.learn.server.service.MessageTopic;
import org.bob.learn.server.service.StreamProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class StreamProducerServiceImpl implements StreamProducerService {

    @Autowired
    private MessageTopic messageTopic;

    @Override
    public void produce() {
        messageTopic.reportMoniter().send(MessageBuilder.withPayload("dsd").build());
    }
}

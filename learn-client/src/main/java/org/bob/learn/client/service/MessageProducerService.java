package org.bob.learn.client.service;

import org.bob.learn.client.common.dto.Message;

public interface MessageProducerService {
    void send(Message message);
}

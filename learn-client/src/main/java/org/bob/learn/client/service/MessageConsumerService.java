package org.bob.learn.client.service;

import org.bob.learn.client.common.dto.Message;

public interface MessageConsumerService {
    void receive(Message message);
}

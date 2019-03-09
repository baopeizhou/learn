package org.bob.learn.server.service;

import org.bob.learn.client.common.dto.Message;

public interface MessageConsumerService {
    void receive(Message message);
}

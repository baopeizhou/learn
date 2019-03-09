package org.bob.learn.server.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MessageTopic {

    String COMMAND = "command";

    String REPORT = "monitor";

    @Input(MessageTopic.COMMAND)
    SubscribableChannel receiveCommand();

    @Output(MessageTopic.REPORT)
    MessageChannel reportMoniter();

}

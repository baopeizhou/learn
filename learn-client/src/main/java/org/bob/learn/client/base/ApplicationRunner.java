package org.bob.learn.client.base;

import org.bob.learn.client.common.dto.Message;
import org.bob.learn.client.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private MessageProducerService messageProducerService;

    @Override
    public void run(String... args) throws Exception {
        Message message = new Message();
        message.setValue("asfsadfsfsaf");
        messageProducerService.send(message);
    }
}

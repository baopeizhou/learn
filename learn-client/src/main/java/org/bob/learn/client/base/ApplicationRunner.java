package org.bob.learn.client.base;

import lombok.extern.slf4j.Slf4j;
import org.bob.learn.client.api.course.CourseApiService;
import org.bob.learn.client.api.course.CourseReq;
import org.bob.learn.client.common.dto.Message;
import org.bob.learn.client.dao.mapper.DeviceOnlineMapper;
import org.bob.learn.client.service.DeviceService;
import org.bob.learn.client.service.MessageProducerService;
import org.bob.learn.client.util.SequenceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private DeviceOnlineMapper deviceOnlineMapper;

   /* @Autowired
    private MessageProducerService messageProducerService;*/

    @Autowired
    private CourseApiService courseApiService;

    @Override
    public void run(String... args) throws Exception {
        deviceService.test();
    }
}

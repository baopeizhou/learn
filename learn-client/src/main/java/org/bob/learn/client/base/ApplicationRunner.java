package org.bob.learn.client.base;

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
        deviceOnlineMapper.deleteAll();
        for(long i=0;i<40000000;i++){
            String mac = String.format("%012d", i);
            deviceService.online(mac,mac);
        }

    }
}

package org.bob.learn.client.base;

import org.bob.learn.client.api.course.CourseApiService;
import org.bob.learn.client.api.course.CourseReq;
import org.bob.learn.client.common.dto.Message;
import org.bob.learn.client.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private MessageProducerService messageProducerService;

    @Autowired
    private CourseApiService courseApiService;

    @Override
    public void run(String... args) throws Exception {
        try{
            CourseReq req = new CourseReq();
            courseApiService.listCourse(req);
        }catch (Exception e){

        }

    }
}

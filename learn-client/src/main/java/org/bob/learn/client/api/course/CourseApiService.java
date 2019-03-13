package org.bob.learn.client.api.course;

import org.bob.learn.client.api.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "courseApiService", url = "${addressConfig.localeAddress}",configuration = FeignHeaderInterceptor.class,fallbackFactory = CourseApiServiceFallbackFactory.class)
public interface CourseApiService {

    @PostMapping("/course/list")
    Result listCourse(@RequestBody CourseReq req);
}

package org.bob.learn.client.api.course;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 课程接口服务FALLBACK工厂实现类
 */
@Slf4j
@Component
public class CourseApiServiceFallbackFactory implements FallbackFactory<CourseApiService> {

    @Override
    public CourseApiService create(Throwable throwable) {
        log.error("调用用户本地化环境信息接口异常[{}].",throwable.getMessage());
        return null;
    }
}

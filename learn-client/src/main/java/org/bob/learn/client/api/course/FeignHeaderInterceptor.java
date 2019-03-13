package org.bob.learn.client.api.course;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * FeignHeader拦截器
 */
@Component
public class FeignHeaderInterceptor implements RequestInterceptor {

    /**
     * 设置头部
     * @param requestTemplate 请求模板
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Content-Type","application/json;charset=UTF-8");
        requestTemplate.header("Accept","application/json");
    }
}

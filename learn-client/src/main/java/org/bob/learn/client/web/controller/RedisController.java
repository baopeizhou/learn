package org.bob.learn.client.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

import org.bob.learn.agent.Agent;
import org.bob.learn.client.common.dto.Device;
import org.bob.learn.client.util.JacksonUtils;
import org.bob.learn.client.util.RedisUtils;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {



    @GetMapping("/set")
    public String set(){
        long key =ThreadLocalRandom.current().nextLong(10000000);
        RedisUtils.set(String.valueOf(key),String.valueOf(key));
        Device device = new Device();
        device.setMac("DS12SF32SDF22");
        device.setSn("DS12SF32SDF22");
        device.setProvince("59");
        String sd = JacksonUtils.toJson(device);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<Object> dd = new ArrayList<>(10000);
        for(int i=0;i<100000;i++){
            dd.add(JacksonUtils.fromJson(sd, JSONObject.class));
        }

        System.out.println(Agent.fullSizeOf(dd));
        stopWatch.stop();

        System.out.println(stopWatch.shortSummary());
        return "200";
    }

    @GetMapping("/get")
    public String get(){
        set();
        LettuceConnectionFactory dd;
        long key =ThreadLocalRandom.current().nextLong(10000000);
        RedisUtils.get(String.valueOf(key));
        del();
        return "200";
    }
    public String del(){
        long key =ThreadLocalRandom.current().nextLong(10000000);
        RedisUtils.del(String.valueOf(key));
        return "200";
    }
}

package org.bob.learn.client.web.controller;


import lombok.extern.slf4j.Slf4j;

import org.bob.learn.client.util.RedisUtils;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {

    @PostMapping("/set")
    public String set(){
        long key =ThreadLocalRandom.current().nextLong(10000000);
        RedisUtils.set(String.valueOf(key),String.valueOf(key));
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

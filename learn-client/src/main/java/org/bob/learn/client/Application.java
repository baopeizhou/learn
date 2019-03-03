package org.bob.learn.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Slf4j
@ServletComponentScan
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        log.info("learn-client应用启动开始！");
        SpringApplication.run(Application.class,args);
        log.info("learn-client应用启动成功！");
    }
}

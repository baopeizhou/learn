package org.bob.learn.client.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.bob.learn.client.dao.mapper.DeviceOnlineMapper;
import org.bob.learn.client.dao.model.DeviceOnline;
import org.bob.learn.client.service.DeviceService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@EnableAsync
@Service
public class DeviceServiceImpl implements DeviceService {

    @Resource
    private DeviceOnlineMapper deviceOnlineMapper;

    @Override
    public void online(String mac, String dmac) {
        DeviceOnline param = new DeviceOnline();
        param.setMac(mac);
        param.setDmac(dmac);
        deviceOnlineMapper.insert(param);
    }

    @Async
    @Override
    public void test() {
        List<String> macList= new ArrayList<>();
        for(long i=0;i<20000000;i++){
            String mac = String.format("%012d", i);
            macList.add(mac);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        macList.stream().parallel().forEach(mac-> this.online(mac,mac));
        stopWatch.stop();

        log.error(stopWatch.shortSummary());
    }
}

package org.bob.learn.client.service.impl;

import org.bob.learn.client.dao.mapper.DeviceOnlineMapper;
import org.bob.learn.client.dao.model.DeviceOnline;
import org.bob.learn.client.service.DeviceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Resource
    private DeviceOnlineMapper deviceOnlineMapper;

    @Override
    public void online(String mac, String dmac) {
        DeviceOnline param = new DeviceOnline();
        param.setMac(mac);
        param.setDmac(dmac);
        deviceOnlineMapper.update(param);
    }
}

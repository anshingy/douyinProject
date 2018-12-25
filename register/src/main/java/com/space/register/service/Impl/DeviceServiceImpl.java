package com.space.register.service.Impl;


import com.space.register.dao.DeviceRepository;
import com.space.register.entity.DeviceEntity;
import com.space.register.service.DeviceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {

    @Resource
    DeviceRepository DeviceRepository;

    @Override
    public DeviceEntity getDeviceMsg(int id) {
        DeviceEntity DeviceEntity = DeviceRepository.getDeviceMsgById(id);
        return DeviceEntity;
    }
}

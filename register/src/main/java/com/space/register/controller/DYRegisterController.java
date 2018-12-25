package com.space.register.controller;

import com.space.register.dao.DeviceRepository;
import com.space.register.entity.DYUserEntity;
import com.space.register.entity.DeviceEntity;
import com.space.register.service.DYRegisterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/dy")
public class DYRegisterController {

    @Resource
    DYRegisterService dyRegisterService;

    @Resource
    DeviceRepository deviceRepository;

    @RequestMapping("/register")
    public String dyRegister() {
        DYUserEntity dyUserEntity = new DYUserEntity();
        dyUserEntity.setName("abc");
        dyRegisterService.testSaveAccount(dyUserEntity);
        DeviceEntity entity =new DeviceEntity();

        deviceRepository.save(entity);

        return "abc";
    }
}

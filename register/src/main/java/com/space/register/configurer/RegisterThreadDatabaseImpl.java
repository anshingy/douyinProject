package com.space.register.configurer;

import com.space.register.dao.DYUserRepository;
import com.space.register.dao.DeviceRepository;
import com.space.register.entity.DYUserEntity;
import com.space.register.entity.DeviceEntity;
import com.space.register.service.DeviceService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Auther: Administrator
 * @Date: 2018/9/21/021 20:56
 * @Description:
 */
@Component
public class RegisterThreadDatabaseImpl {

    @Resource
    protected DeviceService deviceService;
    @Resource
    protected DYUserRepository DYUserRepository;
    @Resource
    protected DeviceRepository deviceRepository;

    private static RegisterThreadDatabaseImpl registerThreadDatabaseImpl;

    @PostConstruct
    public void init() {
        if(registerThreadDatabaseImpl == null){
            registerThreadDatabaseImpl = this;
        }
    }

    /**
     * 存储deviceEntity
     * @param deviceEntity
     * @return
     */
    public DeviceEntity saveDevice(DeviceEntity deviceEntity) {
        return registerThreadDatabaseImpl.deviceRepository.save(deviceEntity);
    }

    /**
     * 存储用户实体类方法
     * @param dyUserEntity
     * @return
     */
    public DYUserEntity saveUser(DYUserEntity dyUserEntity){
        return registerThreadDatabaseImpl.DYUserRepository.save(dyUserEntity);
    }
}

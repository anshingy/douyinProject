package com.space.register.dao;

import com.space.register.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface DeviceRepository extends JpaRepository<DeviceEntity, Integer>, JpaSpecificationExecutor<DeviceEntity> {


    /**
     * 根据id返回device的信息
     * @param id
     * @return
     */
    @Query(value = "select * from t_device where id = ?1", nativeQuery = true)
    DeviceEntity getDeviceMsgById(int id);


    /**
     * 返回device的信息
     * @return
     */
    @Query(value = "select * from t_device", nativeQuery = true)
    DeviceEntity getAllDeviceMsg();
}

package com.space.register.service.Impl;


import com.space.register.dao.DYUserRepository;
import com.space.register.entity.DYUserEntity;
import com.space.register.service.DYRegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("dyRegisterService")
public class DYRegisterServiceImpl implements DYRegisterService {

    @Resource
    DYUserRepository dyUserRepository;

    @Override
    public void testSaveAccount(DYUserEntity dyUserEntity) {
        DYUserEntity save = dyUserRepository.save(dyUserEntity);
        System.out.println(save);
    }

    @Override
    public DYUserEntity findById(int id) {
        DYUserEntity dyUserEntity = dyUserRepository.findById(id);
        return dyUserEntity;
    }

    @Override
    public ArrayList<DYUserEntity> findAll() {
        ArrayList<DYUserEntity> dyUserEntity = dyUserRepository.findAll();
        return dyUserEntity;
    }
}

package com.space.register.service;

import com.space.register.entity.DYUserEntity;

import java.util.ArrayList;

public interface DYRegisterService {

    public void testSaveAccount(DYUserEntity userEntity);

    public DYUserEntity findById(int id);

    public ArrayList<DYUserEntity> findAll();
}

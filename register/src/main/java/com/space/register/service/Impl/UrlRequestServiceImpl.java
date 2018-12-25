package com.space.register.service.Impl;



import com.space.register.dao.UrlRequestRepository;

import com.space.register.entity.UrlRequestEntity;
import com.space.register.service.UrlRequestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("urlRequestService")
public class UrlRequestServiceImpl implements UrlRequestService {

    @Resource
    UrlRequestRepository urlRequestRepository;

    @Override
    public UrlRequestEntity getUrlRequest(int id) {
        UrlRequestEntity urlRequestEntity = urlRequestRepository.findUrlById(id);
        return urlRequestEntity;
    }
}

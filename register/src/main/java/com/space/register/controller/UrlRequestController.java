package com.space.register.controller;

import com.space.register.entity.UrlRequestEntity;
import com.space.register.service.UrlRequestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/urlRequest")
public class UrlRequestController {

    @Resource
    UrlRequestService urlRequestService;

    @RequestMapping("/getUrl")
    public String getUrlRequest() {
        UrlRequestEntity urlRequestEntity = new UrlRequestEntity();
//        urlRequestEntity.setHost("11224243279847931");
//        urlRequestEntity.setId(11);
        urlRequestService.getUrlRequest(1);
        return "abc";
    }
}

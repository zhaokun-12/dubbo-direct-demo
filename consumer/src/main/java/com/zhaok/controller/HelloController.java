package com.zhaok.controller;

import com.zhaok.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


//    @DubboReference(url = "dubbo://127.0.0.1:20880") 单独指定
    @DubboReference
    private HelloService helloService;

    @GetMapping("testDirect")
    public String testDirect() {
        return helloService.test();
    }
}

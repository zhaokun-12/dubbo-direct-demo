package com.zhaok.service;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String test() {
        System.out.println("测试直连服务");
        return "测试直连服务测试成功";
    }
}

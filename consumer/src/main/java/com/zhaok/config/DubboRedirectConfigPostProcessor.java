package com.zhaok.config;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.config.ConfigPostProcessor;
import org.apache.dubbo.config.ReferenceConfig;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;

@Activate(group = {CommonConstants.CONSUMER})
public class DubboRedirectConfigPostProcessor implements ConfigPostProcessor, EnvironmentAware {

    public static final String DUBBO_URL = "dubbo://127.0.0.1:20880";

    private List<String> activeProfiles;

    public void postProcessReferConfig(ReferenceConfig referenceConfig) {
        if (!activeProfiles.contains("dev")) {
            // 仅在开发环境使用直连方式
            return;
        }

        // 可以根据包名等判断 设置dubbo url等内容
        System.out.println("dubbo扩展 " + referenceConfig.getServiceMetadata().getServiceType());
        referenceConfig.setUrl(DUBBO_URL);
    }

    @Override
    // dubbo 实例化此类后，从spring上下文对象中获取Environment对象作为参数执行
    public void setEnvironment(Environment environment) {
        this.activeProfiles = Arrays.asList(environment.getActiveProfiles());
    }
}

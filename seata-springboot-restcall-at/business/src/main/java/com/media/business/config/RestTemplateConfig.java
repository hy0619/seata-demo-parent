package com.media.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Author Hero
 * @Date 2021/5/7
 * @Version 1.0.0
 */
@Component
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

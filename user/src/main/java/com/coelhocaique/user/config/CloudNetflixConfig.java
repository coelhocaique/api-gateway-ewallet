package com.coelhocaique.user.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients("com.coelhocaique.user.feign")
public class CloudNetflixConfig {

}

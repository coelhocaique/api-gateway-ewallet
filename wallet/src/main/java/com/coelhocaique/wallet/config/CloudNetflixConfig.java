package com.coelhocaique.wallet.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients("com.coelhocaique.wallet.feign")
public class CloudNetflixConfig {

}

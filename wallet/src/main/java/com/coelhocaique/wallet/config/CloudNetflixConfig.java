package com.coelhocaique.wallet.config;

import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableHystrixDashboard
@EnableFeignClients("com.coelhocaique.wallet.feign")
public class CloudNetflixConfig {

}

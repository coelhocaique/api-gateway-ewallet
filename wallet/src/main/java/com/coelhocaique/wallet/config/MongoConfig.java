package com.coelhocaique.wallet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages="com.coelhocaique.wallet.repository")
public class MongoConfig {

}

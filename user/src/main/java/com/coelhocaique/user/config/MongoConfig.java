package com.coelhocaique.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages="com.coelhocaique.user.repository")
public class MongoConfig {

}

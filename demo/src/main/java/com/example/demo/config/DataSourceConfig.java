package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:datasource/sharding-spwhere.xml"})
public class DataSourceConfig {
}

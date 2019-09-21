package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:spring-namespace/user.xml"})
public class NamespaceConfig {
}

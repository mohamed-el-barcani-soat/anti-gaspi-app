package com.soat.anti_gaspi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;


@Configuration
public class EmailConfig {
    @Bean
    HttpClient httpClientFactory() {
        return HttpClient.newHttpClient();
    }
}

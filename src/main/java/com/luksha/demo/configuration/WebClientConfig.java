package com.luksha.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableJpaAuditing
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.create("http://ip-api.com/json");
    }
}

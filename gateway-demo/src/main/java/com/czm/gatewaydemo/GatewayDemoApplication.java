package com.czm.gatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayDemoApplication.class, args);
    }

    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("begin", fn -> fn.path("/api/**")
                        .uri("http://localhost:7799"))
                .route("web", fn -> fn.path("/web/")
                        .uri("https://weread.qq.com"))
                .build();
    }
}

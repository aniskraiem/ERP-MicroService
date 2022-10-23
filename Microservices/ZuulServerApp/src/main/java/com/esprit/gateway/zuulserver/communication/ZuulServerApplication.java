package com.esprit.gateway.zuulserver.communication;

import com.esprit.gateway.zuulserver.filtres.ErrorFilter;
import com.esprit.gateway.zuulserver.filtres.PostFilter;
import com.esprit.gateway.zuulserver.filtres.PreFilter;
import com.esprit.gateway.zuulserver.filtres.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableFeignClients
public class ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }
    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}

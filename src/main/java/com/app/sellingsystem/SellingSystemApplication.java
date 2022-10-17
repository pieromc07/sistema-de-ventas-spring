package com.app.sellingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@SpringBootApplication
public class SellingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellingSystemApplication.class, args);
    }

    @Bean
    public LayoutDialect layoutDialect(){
        return new LayoutDialect();
    }

}

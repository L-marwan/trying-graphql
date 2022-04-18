package com.marouane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GraphqlConfiguration.class)
@EnableAutoConfiguration
public class TryingGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(TryingGraphqlApplication.class, args);
    }

}

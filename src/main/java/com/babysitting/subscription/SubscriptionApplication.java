package com.babysitting.subscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubscriptionApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SubscriptionApplication.class);
        application.run(args);
    }
}

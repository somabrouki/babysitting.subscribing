package com.babysitting.subscription;

import com.babysitting.subscription.core.HashCalculator;
import com.babysitting.subscription.model.User;
import com.babysitting.subscription.model.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.babysitting.subscription.core.HashCalculator.hash256;

@SpringBootApplication
public class SubscriptionApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SubscriptionApplication.class);
        application.run(args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            repository.save(new User()
                    .setFirstName("Bob")
                    .setLastName("Scott")
                    .setZipCode("75001")
                    .setAddress("Rue du Louvre")
                    .setCity("Paris")
                    .setEmail("alice.scott@arolla.fr")
                    .setPassword(hash256("bob2018"))
                    .setPhoneNumber("06 00 00 00 00")
                    .setCountry("France")
            );
        };
    }
}

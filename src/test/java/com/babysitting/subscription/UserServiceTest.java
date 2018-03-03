package com.babysitting.subscription;

import com.babysitting.subscription.core.HashCalculator;
import com.babysitting.subscription.model.UserDto;
import com.babysitting.subscription.core.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void subscribe_a_new_user_succeeds() throws NoSuchAlgorithmException {
        UserDto user = new UserDto()
                .setFirstName("Alice")
                .setLastName("Scott")
                .setAddress("address")
                .setZipCode("73000")
                .setCity("London")
                .setCountry("England")
                .setEmail("alice.scott@babysitting-somabrouki.com")
                .setPassword(HashCalculator.hash256("33@Z>/FrjX:(d+GD"))
                .setPhoneNumber("010000000");

        UserDto result = userService.add(user);

        assertThat(result).isNotNull();
        assertThat(result.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(result.getLastName()).isEqualTo(user.getLastName());
        assertThat(result.getAddress()).isEqualTo(user.getAddress());
        assertThat(result.getZipCode()).isEqualTo(user.getZipCode());
        assertThat(result.getCity()).isEqualTo(user.getCity());
        assertThat(result.getCountry()).isEqualTo(user.getCountry());
        assertThat(result.getEmail()).isEqualTo(user.getEmail());
        assertThat(result.getPassword()).isEqualTo(user.getPassword());
        assertThat(result.getPhoneNumber()).isEqualTo(user.getPhoneNumber());

    }
}

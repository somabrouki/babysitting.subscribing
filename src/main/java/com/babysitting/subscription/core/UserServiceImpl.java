package com.babysitting.subscription.core;

import com.babysitting.subscription.model.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDto add(UserDto user) {
        return new UserDto()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setAddress(user.getAddress())
                .setZipCode(user.getZipCode())
                .setCity(user.getCity())
                .setCountry(user.getCountry())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setPhoneNumber(user.getPhoneNumber());
    }
}

package com.babysitting.subscription.core;

import com.babysitting.subscription.model.UserDto;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {

    UserDto add(UserDto user);

    UserDto getUser(Long id);

    List<UserDto> getUsers();

    void init() throws NoSuchAlgorithmException;
}

package com.babysitting.subscription.core;

import com.babysitting.subscription.model.User;
import com.babysitting.subscription.model.UserDto;
import com.babysitting.subscription.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto add(UserDto user) {
        User userEntity = userRepository.findOne(1L);
        return userMapper.mapEntityToDto(userEntity);
        /*return new UserDto()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setAddress(user.getAddress())
                .setZipCode(user.getZipCode())
                .setCity(user.getCity())
                .setCountry(user.getCountry())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setPhoneNumber(user.getPhoneNumber());*/

    }
}

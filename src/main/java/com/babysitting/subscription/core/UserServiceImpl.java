package com.babysitting.subscription.core;

import com.babysitting.subscription.model.User;
import com.babysitting.subscription.model.UserDto;
import com.babysitting.subscription.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
        User userEntity = userMapper.mapDtoToEntity(user);
        userEntity = userRepository.save(userEntity);
        return userMapper.mapEntityToDto(userEntity);
    }

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findOne(id);
        return userMapper.mapEntityToDto(user);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        ArrayList<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(userMapper.mapEntityToDto(user));
        }
        return users
                .stream()
                .map(userMapper::mapEntityToDto)
                .collect(toList());
    }
}

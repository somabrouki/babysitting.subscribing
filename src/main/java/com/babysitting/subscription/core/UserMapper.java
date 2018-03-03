package com.babysitting.subscription.core;

import com.babysitting.subscription.model.User;
import com.babysitting.subscription.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    @Override
    public User mapDtoToEntity(UserDto userDto) {
        return new User()
                .setId(userDto.getId())
                .setFirstName(userDto.getFirstName())
                .setLastName(userDto.getLastName())
                .setAddress(userDto.getAddress())
                .setZipCode(userDto.getZipCode())
                .setCity(userDto.getCity())
                .setCountry(userDto.getCountry())
                .setEmail(userDto.getEmail())
                .setPassword(userDto.getPassword())
                .setPhoneNumber(userDto.getPhoneNumber());
    }

    @Override
    public UserDto mapEntityToDto(User user) {
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

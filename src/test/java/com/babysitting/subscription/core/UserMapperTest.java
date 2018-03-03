package com.babysitting.subscription.core;

import com.babysitting.subscription.model.User;
import com.babysitting.subscription.model.UserDto;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {

    private UserMapper userMapper;


    @Before
    public void setUp() {
        userMapper = new UserMapper();
    }

    @Test
    public void mapDtoToEntity() {
        User user = new User()
                .setId(1L)
                .setFirstName("Alice")
                .setLastName("Scott")
                .setZipCode("75001")
                .setAddress("Rue du Louvre")
                .setCity("Paris")
                .setEmail("alice.scott@arolla.fr")
                .setPassword("*****")
                .setPhoneNumber("06 00 00 00 00")
                .setCountry("France");

        UserDto result = userMapper.mapEntityToDto(user);

        assertThat(result)
                .isEqualTo(
                        userDto(
                                user.getId(),
                                user.getFirstName(),
                                user.getLastName(),
                                user.getAddress(),
                                user.getZipCode(),
                                user.getCity(),
                                user.getCountry(),
                                user.getPhoneNumber(),
                                user.getEmail(),
                                user.getPassword())
                );
    }

    @Test
    public void mapEntityToDto() {
        UserDto userDto = new UserDto()
                .setId(1L)
                .setFirstName("Alice")
                .setLastName("Scott")
                .setZipCode("75001")
                .setAddress("Rue du Louvre")
                .setCity("Paris")
                .setEmail("alice.scott@arolla.fr")
                .setPassword("*****")
                .setPhoneNumber("06 00 00 00 00")
                .setCountry("France");

        User result = userMapper.mapDtoToEntity(userDto);

        assertThat(result).isEqualTo(
                user(
                        userDto.getId(),
                        userDto.getFirstName(),
                        userDto.getLastName(),
                        userDto.getAddress(),
                        userDto.getZipCode(),
                        userDto.getCity(),
                        userDto.getCountry(),
                        userDto.getPhoneNumber(),
                        userDto.getEmail(),
                        userDto.getPassword())
        );

    }

    private User user(Long id,
                      String firstName,
                      String lastName,
                      String address,
                      String zipCode,
                      String city,
                      String country,
                      String phoneNumber,
                      String email,
                      String password) {
        return new User()
                .setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(address)
                .setZipCode(zipCode)
                .setCity(city)
                .setCountry(country)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setPassword(password);
    }

    private static UserDto userDto(Long id,
                                   String firstName,
                                   String lastName,
                                   String address,
                                   String zipCode,
                                   String city,
                                   String country,
                                   String phoneNumber,
                                   String email,
                                   String password) {
        return new UserDto()
                .setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(address)
                .setZipCode(zipCode)
                .setCity(city)
                .setCountry(country)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setPassword(password);
    }

}
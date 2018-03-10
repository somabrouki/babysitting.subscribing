package com.babysitting.subscription;

import com.babysitting.subscription.core.HashCalculator;
import com.babysitting.subscription.core.UserMapper;
import com.babysitting.subscription.core.UserServiceImpl;
import com.babysitting.subscription.model.User;
import com.babysitting.subscription.model.UserDto;
import com.babysitting.subscription.model.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @Test
    public void should_subscribe_a_new_user() throws NoSuchAlgorithmException {
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
        User userEntity = new User()
                .setId(1L)
                .setFirstName("Alice")
                .setLastName("Scott")
                .setAddress("address")
                .setZipCode("73000")
                .setCity("London")
                .setCountry("England")
                .setEmail("alice.scott@babysitting-somabrouki.com")
                .setPassword(HashCalculator.hash256("33@Z>/FrjX:(d+GD"))
                .setPhoneNumber("010000000");
        given(userMapper.mapDtoToEntity(user)).willReturn(userEntity);
        given(userRepository.save(userEntity)).willReturn(userEntity);
        given(userMapper.mapEntityToDto(userEntity)).willReturn(user.setId(userEntity.getId()));

        UserDto result = userService.add(user);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull();
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

    @Test
    public void search_a_user_by_id() throws NoSuchAlgorithmException {
        User user = new User()
                .setId(1L)
                .setFirstName("Alice")
                .setLastName("Scott")
                .setAddress("address")
                .setZipCode("73000")
                .setCity("London")
                .setCountry("England")
                .setEmail("alice.scott@babysitting-somabrouki.com")
                .setPassword(HashCalculator.hash256("33@Z>/FrjX:(d+GD"))
                .setPhoneNumber("010000000");
        UserDto userDto = new UserDto()
                .setId(1L)
                .setFirstName("Alice")
                .setLastName("Scott")
                .setAddress("address")
                .setZipCode("73000")
                .setCity("London")
                .setCountry("England")
                .setEmail("alice.scott@babysitting-somabrouki.com")
                .setPassword(HashCalculator.hash256("33@Z>/FrjX:(d+GD"))
                .setPhoneNumber("010000000");
        given(userRepository.findOne(user.getId())).willReturn(user);
        given(userMapper.mapEntityToDto(user)).willReturn(userDto);

        UserDto result = userService.getUser(user.getId());

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull();
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

    @Test
    public void search_all_users() {
        given(userRepository.findAll()).willReturn(Arrays.asList(new User().setId(1L), new User().setId(2L)));

        List<UserDto> users = userService.getUsers();

        assertThat(users)
                .isNotEmpty()
                .hasSize(2);
    }
}

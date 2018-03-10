package com.babysitting.subscription;

import com.babysitting.subscription.core.UserService;
import com.babysitting.subscription.model.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class SubscribingController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() throws JsonProcessingException, NoSuchAlgorithmException {
        userService.init();
        List<UserDto> result = userService.getUsers();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

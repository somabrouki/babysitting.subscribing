package com.babysitting.subscription;

import com.babysitting.subscription.core.UserService;
import com.babysitting.subscription.model.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class SubscribingController {

    @Autowired
    private UserService userService;

    /* @ApiOperation(value = "Create new user", notes = "Create new user", response = UserWithRealmDto.class)
     @PostMapping
     @APIKey(requestedScopes = {USERS_CREATE_INTERNAL, USERS_CREATE_FEDERATE, INTERNAL_CALL})
     public ResponseEntity<?> createUser(@RequestHeader(value = FID_HEADER, required = false) String functionalId,
                                         @Valid @RequestBody UserWithRealmDto user, HttpServletRequest request) {
         Scopes scopes = (Scopes) request.getAttribute(JWTControllerInterceptor.SCOPES);
         boolean isFederation = scopes != null && scopes.hasScope(USERS_CREATE_FEDERATE);
         if (!isFederation && (user.getCountry() == null || user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null || user.getLanguage() == null || user.getPassword() == null || user.getTimezone() == null)) {
             String resultMessage = "{ \"message\": \"There are missing parameters.\" }";
             return new ResponseEntity<>(resultMessage, HttpStatus.BAD_REQUEST);
         }
         return new ResponseEntity<>(userCreation.createUser(user, isFederation, functionalId), HttpStatus.CREATED);
     }
 */
    @ApiOperation(value = "Create new user", notes = "Create new user", response = UserDto.class)
    @GetMapping
    public ResponseEntity<UserDto> getUsers() throws JsonProcessingException {
        UserDto user = new UserDto()
                .setId(1L)
                .setFirstName("Alice")
                .setLastName("Scott");
        UserDto result = userService.add(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

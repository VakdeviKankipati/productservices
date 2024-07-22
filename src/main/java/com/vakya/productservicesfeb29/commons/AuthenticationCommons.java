package com.vakya.productservicesfeb29.commons;

import com.vakya.productservicesfeb29.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationCommons {
    private RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public UserDto validateToken(String token){
        //make a call nto validate token api from userService to validate the token
        UserDto userDto = restTemplate.getForObject(
                "http://localhost:8181/users/validate/" + token,
                UserDto.class
        );
        return userDto;
    }
}

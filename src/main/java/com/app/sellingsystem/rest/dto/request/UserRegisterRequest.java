package com.app.sellingsystem.rest.dto.request;

import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRegisterRequest {
    
    private String username;
    private String email;
    private String password;

}

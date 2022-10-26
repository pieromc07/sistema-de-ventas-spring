package com.app.sellingsystem.service;

import org.springframework.stereotype.Service;

import com.app.sellingsystem.persistence.model.User;
import com.app.sellingsystem.rest.dto.request.UserRegisterRequest;

@Service
public interface IUserService {
    
    User save(UserRegisterRequest userRegisterRequest);
}

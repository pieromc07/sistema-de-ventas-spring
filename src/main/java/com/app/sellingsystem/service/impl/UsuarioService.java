package com.app.sellingsystem.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.sellingsystem.persistence.model.Role;
import com.app.sellingsystem.persistence.model.User;
import com.app.sellingsystem.persistence.repository.UserRepository;
import com.app.sellingsystem.rest.dto.request.UserRegisterRequest;
import com.app.sellingsystem.service.IUserService;

@Service
public class UsuarioService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user.setUsername(userRegisterRequest.getUsername());
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(userRegisterRequest.getPassword());
        // user.setRoles(Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
                        
    }



   

}

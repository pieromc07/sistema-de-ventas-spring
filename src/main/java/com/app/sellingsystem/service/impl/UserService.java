package com.app.sellingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.sellingsystem.persistence.model.User;
import com.app.sellingsystem.persistence.repository.UserRepository;
import com.app.sellingsystem.service.IUserService;

@Service
class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {

        userRepository.save(user);
        
    }
 

}
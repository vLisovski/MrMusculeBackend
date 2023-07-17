package com.lisovski.mrmuscule.services;

import com.lisovski.mrmuscule.models.User;
import com.lisovski.mrmuscule.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User getById(int userId){
        return userRepository.findById(userId).get();
    }



}

package com.antony.electronicstore.service;

import com.antony.electronicstore.entity.User;
import com.antony.electronicstore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public  UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    public User registerUser(User user) {
        System.out.println("isActive before save = " + user.getIsActive());

        Optional<User> existingUser =
                userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Account already exist");
        }
        user.setIsActive(true);
        return userRepository.save(user);
    }

}

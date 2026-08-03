package com.antony.electronicstore.service;

import com.antony.electronicstore.dto.request.RegisterRequest;
import com.antony.electronicstore.dto.response.RegisterResponse;
import com.antony.electronicstore.entity.User;
import com.antony.electronicstore.entity.enums.Role;
import com.antony.electronicstore.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public  UserService(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }


    public RegisterResponse registerUser(RegisterRequest request) {

        Optional<User> existingUser=userRepository.findByEmail(request.getEmail());

        if(existingUser.isPresent()){
            throw new IllegalArgumentException("Email already exists");
        }

        User user =new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setRole(Role.CUSTOMER);
        user.setIsActive(true);

         User savedUser=userRepository.save(user);

         RegisterResponse response=new RegisterResponse();

         response.setUserId(savedUser.getUserId());
         response.setName(savedUser.getName());
         response.setEmail(savedUser.getEmail());

         return response;
    }

}

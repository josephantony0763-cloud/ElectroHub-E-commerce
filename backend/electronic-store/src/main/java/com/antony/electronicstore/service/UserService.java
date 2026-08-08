package com.antony.electronicstore.service;

import com.antony.electronicstore.dto.request.LoginRequest;
import com.antony.electronicstore.dto.request.RegisterRequest;
import com.antony.electronicstore.dto.response.LoginResponse;
import com.antony.electronicstore.dto.response.RegisterResponse;
import com.antony.electronicstore.entity.User;
import com.antony.electronicstore.entity.enums.Role;
import com.antony.electronicstore.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public  UserService(UserRepository userRepository,PasswordEncoder passwordEncoder,JwtService jwtService){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.jwtService=jwtService;
    }


    public RegisterResponse register(RegisterRequest request) {

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

    public LoginResponse login(LoginRequest request){

        Optional<User> existingUser=userRepository.findByEmail(request.getEmail());

        if(existingUser.isEmpty()){
            throw new IllegalArgumentException("Email or password incorrect");
        }

        User user=existingUser.get();
        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new IllegalArgumentException("Email or password incorrect");
        }

        String token = jwtService.generateToken(user);
        LoginResponse response=LoginResponse.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .name(user.getName())
                .token(token)
                .build();
        return response;
    }

}

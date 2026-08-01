package com.antony.electronicstore.entity;

import com.antony.electronicstore.entity.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @NotBlank
    @Column(nullable = false,length = 100)
    private String name;

    @Email
    @NotBlank
    @Column(nullable = false,unique = true,length = 100)
    private String email;

    @NotBlank
    @Column(nullable = false,length = 255)
    private String password;


    @Column(length = 15)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "is_active",nullable = false)
    private Boolean isActive=true;

}


package com.antony.electronicstore.dto.response;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RegisterResponse {

    private Integer userId;

    private String name;

    private String email;
}

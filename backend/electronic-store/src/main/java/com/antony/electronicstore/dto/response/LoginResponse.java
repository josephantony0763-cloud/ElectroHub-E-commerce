package com.antony.electronicstore.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {

    private Integer userId;

    private  String name;

    private String email;
}

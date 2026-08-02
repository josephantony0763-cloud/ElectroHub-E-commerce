package com.antony.electronicstore.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    @Pattern(
            regexp = "^(\\+91[- ]?)?[6-9][0-9]{9}$",
            message = "Enter a valid Indian phone number"
    )
    private String phone;

}

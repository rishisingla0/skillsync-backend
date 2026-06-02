package com.skillsync.dto;

import jakarta.validation.constraints.*;

public class UserRequestDTO {

    @NotBlank
    public String name;

    @Email
    public String email;

    @Size(min = 6)
    public String password;
}

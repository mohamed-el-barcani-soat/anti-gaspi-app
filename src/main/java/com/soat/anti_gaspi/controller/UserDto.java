package com.soat.anti_gaspi.controller;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {

    @NotEmpty
    private final String username;

    @Email
    @NotEmpty
    private final String email;
}

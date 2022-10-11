package com.soat.anti_gaspi.controller;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    @NotEmpty
    private String username;

    @Email
    @NotEmpty
    private String email;
}

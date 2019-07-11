package com.diginepal.schoolmgmt.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String email;
    private String password;
    private String role;
    private String username;
}

package com.example.spring.security.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginDto {

    private final String userEmail;
    private final String password;
}

package com.authentication.springsecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGeneretor {
    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawpassword = "password";
        String encodedPaswword = encoder.encode(rawpassword);
        System.out.println(encodedPaswword);
    }
}

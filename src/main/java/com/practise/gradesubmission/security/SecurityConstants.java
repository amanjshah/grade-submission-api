package com.practise.gradesubmission.security;

public class SecurityConstants {
    public static final String ENCODED_KEY = "Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E="; // Encoded secret key
    public static final int TOKEN_EXPIRATION = 7200000; // 7200000 milliseconds = 2 hours.
    public static final String BEARER = "Bearer "; // Authorization : "Bearer " + Token 
    public static final String AUTHORIZATION = "Authorization"; // "Authorization" : Bearer Token
    public static final String REGISTER_PATH = "/user/register";
}

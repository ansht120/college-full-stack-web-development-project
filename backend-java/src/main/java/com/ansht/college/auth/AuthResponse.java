package com.ansht.college.auth;

public record AuthResponse(
        String accessToken,
        String tokenType,
        String email,
        String fullName,
        Role role
) {
}

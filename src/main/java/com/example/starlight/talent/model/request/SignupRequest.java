package com.example.starlight.talent.model.request;

import lombok.Builder;

import java.util.Set;

@Builder
public record SignupRequest(
        String username,
        String mail,
        String password,
        Set<String> roles
) {
}

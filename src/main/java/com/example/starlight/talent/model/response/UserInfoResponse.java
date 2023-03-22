package com.example.starlight.talent.model.response;

import lombok.Builder;

import java.util.List;

@Builder
public record UserInfoResponse(
        String username,
        String mail,
        List<String> roles
) {
}

package com.example.starlight.talent.model.request;

import lombok.Builder;

@Builder
public record LoginRequest(
        String username,
        String password
) {
}

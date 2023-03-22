package com.example.starlight.talent.model.response;

import lombok.Builder;

@Builder
public record TalentSession(
        String talentId,
        String sessionId
) {
}

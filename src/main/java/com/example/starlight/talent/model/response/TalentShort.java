package com.example.starlight.talent.model.response;

import lombok.Builder;

import java.util.List;

@Builder
public record TalentShort(
        String name,
        String avatar,
        List<String> positions
) {
}

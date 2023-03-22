package com.example.starlight.talent.model.response;

import com.example.starlight.talent.model.entity.PositionEntity;
import lombok.Builder;

import java.util.List;

@Builder
public record TalentFullInfo(
        String fullName,
        String mail,
        Integer age,
        String avatar,
        String education,
        String experience,
        List<PositionEntity> positions
) {
}

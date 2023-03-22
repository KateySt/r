package com.example.starlight.talent;

import com.example.starlight.talent.model.entity.PositionEntity;
import com.example.starlight.talent.model.entity.TalentEntity;
import com.example.starlight.talent.model.response.TalentFullInfo;
import com.example.starlight.talent.model.response.TalentShort;
import com.example.starlight.talent.model.response.TalentsPagination;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface TalentMapper {
    default TalentsPagination toTalentsPagination(Page<TalentEntity> talentEntityPage) {
        if (talentEntityPage == null) {
            return null;
        }
        return TalentsPagination.builder()
                .talents(talentEntityPage.getContent().stream()
                        .map(this::toTalentShort)
                        .toList())
                .totalTalents(talentEntityPage.getTotalElements())
                .totalPage(talentEntityPage.getTotalPages())
                .build();
    }

    default TalentShort toTalentShort(TalentEntity talent) {
        if (talent == null) {
            return null;
        }
        return TalentShort.builder()
                .name(talent.getFullName())
                .avatar(talent.getAvatarUrl())
                .positions(talent.getPositions().stream()
                        .map(PositionEntity::getPosition).toList())
                .build();
    }

    default TalentFullInfo toTalentFullInfo(TalentEntity talent) {
        return TalentFullInfo.builder()
                .fullName(talent.getFullName())
                .mail(talent.getMail())
                .age(talent.getAge())
                .avatar(talent.getAvatarUrl())
                .experience(talent.getExperience())
                .education(talent.getEducation())
                .positions(talent.getPositions().stream().toList())
                .build();
    }
}

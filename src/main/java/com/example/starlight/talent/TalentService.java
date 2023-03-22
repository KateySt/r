package com.example.starlight.talent;

import com.example.starlight.talent.TalentMapper;
import com.example.starlight.talent.TalentNotFoundException;
import com.example.starlight.talent.model.entity.TalentEntity;
import com.example.starlight.talent.model.response.TalentFullInfo;
import com.example.starlight.talent.model.response.TalentSession;
import com.example.starlight.talent.model.response.TalentsPagination;
import com.example.starlight.talent.repository.TalentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TalentService {
    TalentRepository talentRepository;
    TalentMapper mapper;

    public TalentsPagination talentsPagination(int page, int size) {
        return mapper.toTalentsPagination(talentRepository.findAll(PageRequest.of(page, size)));
    }

    public TalentFullInfo talentFullInfo(long id) {
        return talentRepository.findById(id)
                .map(mapper::toTalentFullInfo)
                .orElseThrow(() -> new TalentNotFoundException(id));
    }

    public TalentEntity talentChangeInfo(TalentEntity newTalent, Long talentId) {
        return talentRepository.findById(talentId)
                .map(talent -> {
                    talent.setFullName(newTalent.getFullName());
                    talent.setAge(newTalent.getAge());
                    talent.setMail(newTalent.getMail());
                    talent.setExperience(newTalent.getExperience());
                    talent.setEducation(newTalent.getEducation());
                    talent.setAvatarUrl(newTalent.getAvatarUrl());
                    return talentRepository.save(talent);
                }).orElseGet(() -> talentRepository.save(newTalent));
    }

    public void deleteTalentById(Long talentId) {
        talentRepository.deleteById(talentId);
    }
}

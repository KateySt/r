package com.example.starlight.talent;

import com.example.starlight.talent.model.entity.TalentEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TalentController {
    TalentRepository talentRepository;

    @GetMapping("/talent")
    public Page<TalentEntity>getAllTalents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        return talentRepository.findAll(PageRequest.of(page, size));
    }
}
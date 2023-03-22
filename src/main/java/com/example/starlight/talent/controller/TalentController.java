package com.example.starlight.talent.controller;

import com.example.starlight.talent.TalentService;
import com.example.starlight.talent.model.entity.TalentEntity;
import com.example.starlight.talent.model.response.TalentFullInfo;
import com.example.starlight.talent.model.response.TalentsPagination;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TalentController {
    TalentService talentService;

    @GetMapping("/talents")
    public TalentsPagination getAllTalents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return talentService.talentsPagination(page, size);
    }

    @GetMapping("/talents/{talentId}")
    @PreAuthorize("hasRole('TALENT')")
    public TalentFullInfo searchTalentById(@PathVariable(value = "talentId") Long talentId) {
        return talentService.talentFullInfo(talentId);
        //todo session id
    }

    @PatchMapping("/talents/{talentId}")
    @PreAuthorize("hasRole('TALENT')")
    public TalentEntity replaceTalent(@RequestBody TalentEntity newTalent,
                                      @PathVariable(value = "talentId") Long talentId) {
        return talentService.talentChangeInfo(newTalent, talentId);
        //todo session id
    }

    @DeleteMapping("/talents/{talentId}")
    @PreAuthorize("hasRole('TALENT')")
    public void deleteTalent(@PathVariable(value = "talentId") Long talentId) {
        talentService.deleteTalentById(talentId);
        //todo session id
    }
}
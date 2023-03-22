package com.example.starlight.talent.security.service;

import com.example.starlight.talent.TalentNotFoundException;
import com.example.starlight.talent.model.entity.TalentEntity;
import com.example.starlight.talent.repository.TalentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    TalentRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name)
            throws TalentNotFoundException {
        TalentEntity user = userRepository.findByFullName(name)
                .orElseThrow(() -> new TalentNotFoundException("Talent Not Found with talent name: " + name));
        return UserDetailsImpl.build(user);
    }
}

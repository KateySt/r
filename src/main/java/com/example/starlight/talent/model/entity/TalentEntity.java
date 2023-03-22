package com.example.starlight.talent.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TalentEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long talentId;
    String fullName;
    String mail;
    String password;
    Integer age;
    String avatarUrl;
    String education;
    String experience;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "talent_position",
            joinColumns = @JoinColumn(name = "talent_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id"))
    @JsonManagedReference
    private Set<PositionEntity> positions;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "talent_role",
            joinColumns = @JoinColumn(name = "talent_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonManagedReference
    Set<Role> roles;

    public TalentEntity(String username, String mail, String encode) {
        this.fullName = username;
        this.mail = mail;
        this.password = encode;
    }
}

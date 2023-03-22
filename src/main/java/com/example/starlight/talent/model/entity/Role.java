package com.example.starlight.talent.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Role {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    ERole role;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    Set<TalentEntity> talents;
}

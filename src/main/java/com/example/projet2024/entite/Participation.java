package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Participation")

public class Participation {
    @Id
    @Column(name = "ParticipationID")
    @GeneratedValue(strategy =GenerationType.IDENTITY)

    private Long ParticipationID ;
    @ManyToOne
    User user;
    @ManyToOne
    Competition competition;
}
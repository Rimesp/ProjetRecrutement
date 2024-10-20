package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Competition")

public class Competition {
    @Id
    @Column(name = "CompetitionID")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long CompetitionID ;
    @Basic
    @Column(name = "Result")
    private  String Result ;
    @Basic
    @Column(name = "Description")
    private  String Description ;
    @Temporal (TemporalType.DATE)
    @Column(name = "Startdate")
    private Date Startdate ;
    @Temporal (TemporalType.DATE)
    @Column(name = "EndDate")
    private Date EndDate ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="competition")
    private Set<Participation> Participations;
}

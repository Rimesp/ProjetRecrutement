package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TrainingCenter")

public class TrainingCenter {

    @Id
    @Column(name = "TrainingcenterID")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long TrainingcenterID ;
    @Basic
    @Column(name = "Capacity")
    private Long Capacity ;
    @Basic
    @Column(name = "Name")
    private String  Name ;
    @Basic
    @Column(name = "Adress")
    private String  Adress  ;
    @ManyToMany(mappedBy="trainingcenters", cascade = CascadeType.ALL)
    private Set<User> users;
}

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
@Table(name = "Contract")

public class Contract {
    @Id
    @Column(name = "ContractID")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long ContractID ;
    @Basic
    @Column(name = "Title")
    private String Title ;
    @Basic
    @Column(name = "Description")
    private  String Description ;
    @Temporal (TemporalType.DATE)
    @Column(name = "DateDebut")
    private Date DateDebut ;
    @Temporal (TemporalType.DATE)
    @Column(name = "DateFin")
    private Date DateFin ;
    @Basic
    @Column(name = "Taux")
    private Float Taux ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="contract")
    private Set<Course> Courses;
    @ManyToMany(mappedBy="contracts", cascade = CascadeType.ALL)
    private Set<User> users;
}

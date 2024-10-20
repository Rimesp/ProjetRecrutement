package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "SignPlacement")

public class SignPlacement {

    @Id
    @Column(name = "x")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long x ;
    @Basic
    @Column(name = "y")
    private Long y ;
    @Basic
    @Column(name = "PageNbr")
    private Long PageNbr ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="signplacement")
    private Set<SignProcess> SignProcesss;
}

package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Claim")

public class Claim {
    @Id
    @Column(name = "ClaimId")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long ClaimId ;
    @Basic
    @Column(name = "Title")
    private String Title ;
    @Basic
    @Column(name = "Subject")
    private String Subject ;
    @Basic
    @Column(name = "Status")
    private Boolean Status ;
    @Basic
    @Column(name = "Type")
    private Boolean Type ;
    @OneToOne
    private Response response;
    @ManyToMany(mappedBy="claims", cascade = CascadeType.ALL)
    private Set<User> users;
}

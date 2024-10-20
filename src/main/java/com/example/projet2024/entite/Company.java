package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Company")

public class Company {
    @Id
    //@Column(name = "CompanyID")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id ;
    @Basic
    @Column(name = "Name")
    private String Name ;
    @Basic
    @Column(name = "logo")
    private String logo ;
    @Basic
    @Column(name = "Location")
    private String Location ;
    @Basic
    @Column(name = "Description")
    private String Description ;
    @Basic
    @Column(name = "Industry")
    private String Industry ;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Post> Posts;
    @ManyToMany(mappedBy="companys", cascade = CascadeType.ALL)
    private Set<User> users;
}

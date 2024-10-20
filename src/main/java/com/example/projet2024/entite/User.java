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
@Table(name = "User")

public class User {


    @Id
    @Column(name = "UserId")
    @GeneratedValue(strategy =GenerationType.IDENTITY)

    private Long UserId ;
    @Basic
    @Column(name = "Name")
    private String Name ;
    @Basic
    @Column(name = "Mail")
    private String Mail ;
    @Basic
    @Column(name = "Password")
    private String Password ;
    @Basic
    @Column(name = "Phone")
    private long Phone ;
    @Basic
    @Column(name = "LastUserScore")
    private double lastUserScore ;

    @Temporal (TemporalType.DATE)
    @Column(name = "Dateofbirth")
    private Date Dateofbirth ;
    @Basic
    @Column(name = "Avatar")
    private String Avatar ;
    @Enumerated(EnumType.STRING)
    private Role role ;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Contract> contracts;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Company> companys;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Evaluation> Evaluations;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<TrainingCenter> trainingcenters;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Participation> Participations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Question> questions;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Test> tests;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<ResponseUser> responseUsers;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Calendar> calendars;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Claim> claims;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Article> articles;






    public void setLastUserScore(double newScore) {
        this.lastUserScore = newScore;
    }

    public double getLastUserScore() {
        return this.lastUserScore;
    }

}

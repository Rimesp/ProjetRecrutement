package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "prenomEt")
    private String prenomEt;
    @Basic
    @Column(name = "Title")
    private String Title ;
    @Basic
    @Column(name = "Description")
    private String  Description ;
    @Basic
    @Column(name = "Duration")
    private int Duration ;
    @Temporal (TemporalType.DATE)
    @Column(name = "Start_time")
    private Date Start_time ;
    @Temporal (TemporalType.DATE)
    @Column(name = "End_time")
    private Date End_time ;
    @Column(name = "Status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "post", referencedColumnName = "id")
    @JsonBackReference
    private Post post;
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Question> questions = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}

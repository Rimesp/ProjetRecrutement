package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Post")
public class Post {
    @Id
    //@Column(name = "PostingID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "Title")
    private String Title;
    @Basic
    @Column(name = "Description")
    private String Description;
    @Basic
    @Column(name = "Requirements")
    private String Requirements;
    @Basic
    @Column(name = "Duration")
    private int Duration;
    @Temporal(TemporalType.DATE)
    @Column(name = "StartDate")
    private Date StartDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "EndDate")
    private Date EndDate;
    @OneToOne(mappedBy="post")
    private Appointment appointment;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Test> tests = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @JsonBackReference
    Company company;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
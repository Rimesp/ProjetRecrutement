package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Course")

public class Course {
    @Id
    @Column(name = "CourseID")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long CourseID;
    @Basic
    @Column(name = "Title")
    private String Title;
    @Basic
    @Column(name = "Description")
    private  String Description ;
    @Temporal (TemporalType.DATE)
    @Column(name = "StartDate")
    private Date StartDate ;
    @Temporal (TemporalType.DATE)
    @Column(name = "EndDate")
    private Date EndDate ;
   @Enumerated(EnumType.STRING)
    private Speciality speciality ;
    @OneToOne
    private Certificate certificate;
    @ManyToOne
    Contract contract;

}


package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Meet")

public class Meet {
    @Id
    @Column(name = "MeetID")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long MeetID ;
    @Basic
    @Column(name = "Title")
    private String Title ;
    @Temporal (TemporalType.DATE)
    @Column(name = "StartDate")
    private Date StartDate ;
    @Temporal (TemporalType.DATE)
    @Column(name = "EndDate")
    private Date EndDate ;
    @ManyToOne
    TimeTable timetable;

}
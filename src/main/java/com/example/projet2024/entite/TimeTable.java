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
@Table(name = "TimeTable")

public class TimeTable {
    @Id
    @Column(name = "TimeTableID")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long TimeTableID ;
    @Temporal (TemporalType.DATE)
    @Column(name = "StartDate")
    private Date StartDate ;
    @Temporal (TemporalType.DATE)
    @Column(name = "EndDate")
    private Date EndDate ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="timetable")
    private Set<Meet> Meets;
    /*@OneToOne(mappedBy="timetable")
    private Groupp groupp;*/
}

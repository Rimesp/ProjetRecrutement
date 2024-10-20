package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "Appointment")

public class Appointment {
    @Id
    @Column(name = "AppointmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long AppointmentID ;
    @Temporal(TemporalType.TIMESTAMP)
    private Date start ;
    @Temporal(TemporalType.TIMESTAMP)
    private Date end ;
    private String title ;
    private Long sender;
    private  Long receiver ;
    @Enumerated(EnumType.STRING)
    private AppointementType appointementType ;

    @OneToOne
    private Post post;

    @JsonIgnore
    @ManyToOne
    Classroom classroom;
}

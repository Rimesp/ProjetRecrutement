package com.example.projet2024.entite;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private     Long id ;
    private     String  block ;
    private     Long  classRoomNumber;
    private     String   level;
    @Temporal(TemporalType.TIMESTAMP)
    private      Date start ;
    @Temporal(TemporalType.TIMESTAMP)
    private      Date end ;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="classroom")
    private Set<Appointment> Appointements;


}

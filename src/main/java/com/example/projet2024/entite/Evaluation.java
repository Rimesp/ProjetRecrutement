package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Evaluation")

public class Evaluation {
    @Id
    @Column(name = "EvaluationId")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long EvaluationId ;
    @Basic
    @Column(name = "Title")
    private String Title ;
    @Basic
    @Column(name = "Description")
    private String Description ;
    @ManyToOne
    User user;
}
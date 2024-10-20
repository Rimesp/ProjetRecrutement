package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Internship")

public class Internship extends Post {

    private Long InternshipID ;

}

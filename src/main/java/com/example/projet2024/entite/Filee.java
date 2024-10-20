package com.example.projet2024.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Filee extends Course {
    private Long FileID ;
    private String  Title ;
    private String  Description ;
   @Enumerated(EnumType.STRING)
    private FileType fileType ;

}
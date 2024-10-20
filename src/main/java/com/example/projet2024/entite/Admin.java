package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Admin")

public class Admin {
    @Id
    @Column(name = "AdminId")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private  Long  AdminId ;

    @Basic
    @Column(name = "approval")
    private Boolean approval ;

}
/*
package tn.esprit.templateexamen.entite;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "Admin")
public class Admin extends User {
  @Id
  @Column(name = "AdminId")
  @GeneratedValue(strategy =GenerationType.IDENTITY)
  private  Long  AdminId ;

  @Basic
  @Column(name = "approval")
  private Boolean approval ;

}

 */
package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DigitalCertificate")

public class DigitalCertificate {
    @Id
    @Column(name = "DigCertifId")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private  Long DigCertifId ;
    @Basic
    @Column(name = "PublicKey")
    private  String  PublicKey ;
    @Basic
    @Column(name = "CrtFile")
    private  String CrtFile ;
    @OneToOne(mappedBy="digitalcertificate")
    private SignProcess signprocess;



}
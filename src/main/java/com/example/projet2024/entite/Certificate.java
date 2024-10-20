package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Certificate")

public class Certificate {
    @Id
    @Column(name = "CertificateID")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private  Long CertificateID ;
    @Temporal (TemporalType.DATE)
    @Column(name = "IssueDate")
    private Date IssueDate ;
    @Basic
    @Column(name = "Title")
    private String Title ;
    @OneToOne(mappedBy="certificate")
    private SignProcess signprocess;
    @OneToOne(mappedBy="certificate")
    private Course course;}

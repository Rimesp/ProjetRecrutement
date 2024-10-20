package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "SignProcess")

public class SignProcess {
    @Id
    @Column(name = "Status")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long Status ;
    @Temporal (TemporalType.DATE)
    @Column(name = "TimeStamp")
    private Date TimeStamp ;
    @OneToOne
    private DigitalCertificate digitalcertificate;
    @ManyToOne
    SignPlacement signplacement;
    @OneToOne
    private Certificate certificate;
}

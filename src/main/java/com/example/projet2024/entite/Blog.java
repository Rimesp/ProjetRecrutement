package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Blog")

public class Blog {
    @Id
    @Column(name = "BlogId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long  BlogId ;
    @Basic
    @Column(name = "Name")
    private String Name ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="blog")
    private Set<Article> Articles;
}

package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Article")

public class Article {
    @Id
    @Column(name = "ArticleId")
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long ArticleId ;
    @Basic
    @Column(name = "Title")
    private String Title ;
    @Basic
    @Column(name = "Content")
    private String Content ;
    @Basic
    @Column(name = "Author")
    private String Author ;
    @Basic
    @Column(name = "Category")
    private String Category;
    @Basic
    @Column(name = "Tags")
    private String Tags ;
    @Temporal (TemporalType.DATE)
    @Column(name = "PublicationDate")
    private Date PublicationDate ;
    @ManyToOne
    Blog blog;
    @ManyToOne
    Comment comment;
    @ManyToMany(mappedBy="articles", cascade = CascadeType.ALL)
    private Set<User> users;
}

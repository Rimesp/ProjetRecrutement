package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Comment")

public class Comment {
    @Id
    @Column(name = "CommentId")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long CommentId ;
    @Basic
    @Column(name = "Content")
    private String Content ;
    @Basic
    @Column(name = "React")
    private Boolean React ;




    @OneToMany(cascade = CascadeType.ALL, mappedBy="comment")
    private Set<Article> Articles;
}

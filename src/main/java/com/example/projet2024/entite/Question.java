package com.example.projet2024.entite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;
    @Column(name = "correct-response")
    private String responseCorrect;
    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    @JsonBackReference
    private Test test;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Response> responses = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<ResponseUser> responseUsers = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public String getResponseCorrect() {
        return this.responseCorrect;
    }
}

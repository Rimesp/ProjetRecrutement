package com.example.projet2024.repository;

import com.example.projet2024.entite.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo  extends JpaRepository<Admin,Long> {
}
/*
package tn.esprit.templateexamen.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.templateexamen.entite.Article;

@Repository
public interface AdminRepo extends JpaRepository<Article,Long>{

}

 */
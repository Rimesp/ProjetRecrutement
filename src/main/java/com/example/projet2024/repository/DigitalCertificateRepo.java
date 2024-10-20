package com.example.projet2024.repository;

import com.example.projet2024.entite.DigitalCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DigitalCertificateRepo extends JpaRepository<DigitalCertificate,Long> {
}

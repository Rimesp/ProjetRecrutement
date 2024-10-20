package com.example.projet2024.service;

import com.example.projet2024.entite.Company;
import com.example.projet2024.interfaceService.companyInterface;
import com.example.projet2024.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class companyService implements companyInterface {

    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public Company addcompany(Company company) {
        return companyRepo.save(company);
    }

    @Override
    public List<Company> retrieveAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepo.findById(id).orElseThrow();
    }

    @Override
    public void removecompany(Long id) {
        companyRepo.deleteById(id);
    }

    @Override
    public Company modifyCompany(Company company, Long id) {
        Company updatedCompany = companyRepo.findById(id).orElseThrow();
        updatedCompany.setName(company.getName());
        updatedCompany.setDescription(company.getDescription());
        updatedCompany.setLocation(company.getLocation());
        updatedCompany.setIndustry(company.getIndustry());
        updatedCompany.setLogo(company.getLogo());
        return companyRepo.save(updatedCompany);
    }
}

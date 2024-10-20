package com.example.projet2024.interfaceService;

import com.example.projet2024.entite.Company;

import java.util.List;

public interface companyInterface {
    public Company addcompany(Company company);

    public List<Company> retrieveAllCompanies();

    public Company getCompanyById(Long id);

    public void removecompany(Long id);

    public Company modifyCompany(Company company, Long id);
}

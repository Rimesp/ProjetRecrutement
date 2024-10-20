package com.example.projet2024.controller;

import com.example.projet2024.entite.Company;
import com.example.projet2024.interfaceService.companyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@CrossOrigin("*")
public class companyController {

    @Autowired
    private companyInterface companyInterface;

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return companyInterface.addcompany(company);
    }

    @GetMapping
    public List<Company> getCompanies() {
        return companyInterface.retrieveAllCompanies();
    }

    @GetMapping("/{company-id}")
    public Company getCompanyById(@PathVariable("company-id") Long id) {
        return companyInterface.getCompanyById(id);
    }

    @DeleteMapping("/{company-id}")
    public void removeCompany(@PathVariable("company-id") Long id) {
        companyInterface.removecompany(id);
    }

    @PutMapping("/{id}")
    public Company modifyCompany(@PathVariable Long id, @RequestBody Company company) {
        return companyInterface.modifyCompany(company, id);
    }


}

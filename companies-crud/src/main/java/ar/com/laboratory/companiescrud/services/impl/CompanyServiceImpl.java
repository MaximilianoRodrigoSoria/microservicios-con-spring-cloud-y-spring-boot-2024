package ar.com.laboratory.companiescrud.services.impl;

import ar.com.laboratory.companiescrud.entities.Category;
import ar.com.laboratory.companiescrud.entities.Company;
import ar.com.laboratory.companiescrud.repositories.CompanyRepository;
import ar.com.laboratory.companiescrud.services.CompanyService;
import ar.com.laboratory.companiescrud.util.exceptions.RecordNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.Objects;


@Transactional
@Service
@AllArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Override
    public Company readByName(String name) throws RecordNotFoundException {
        return companyRepository.findByName(name).orElseThrow(()-> new RecordNotFoundException("Company"));
    }

    @Override
    public Company created(Company company) {
        company.getWebsites().forEach(website -> {
            if (Objects.isNull(website)) {
                website.setCategory(Category.NONE);
            }
        });
        return companyRepository.save(company);
    }

    @Override
    public Company update(Company company, String name) throws RecordNotFoundException {
        var companyUpdate = companyRepository.findByName(name).orElseThrow(()-> new RecordNotFoundException("Company"));
        companyUpdate.setLogo(company.getLogo());
        companyUpdate.setFoundationDate(company.getFoundationDate());
        companyUpdate.setFounder(company.getFounder());
        return companyRepository.save(companyUpdate);
    }

    @Override
    public void delete(String name) throws RecordNotFoundException {
        var companyDelete = companyRepository.findByName(name).orElseThrow(()-> new RecordNotFoundException("Company"));
        companyRepository.delete(companyDelete);
    }
}

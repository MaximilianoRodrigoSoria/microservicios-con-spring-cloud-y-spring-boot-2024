package ar.com.laboratory.companiescrud.services.impl;

import ar.com.laboratory.companiescrud.entities.Category;
import ar.com.laboratory.companiescrud.entities.Company;
import ar.com.laboratory.companiescrud.repositories.CompanyRepository;
import ar.com.laboratory.companiescrud.services.CompanyService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.Objects;


@Transactional
@Service
@AllArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Override
    public Company readByName(String name) throws NoSuchObjectException {
        return companyRepository.findByName(name).orElseThrow(()-> new NoSuchObjectException("Company not found"));
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
    public Company update(Company company, String name) throws NoSuchObjectException {
        var companyUpdate = companyRepository.findByName(name).orElseThrow(()-> new NoSuchObjectException("Company not found"));
        companyUpdate.setLogo(company.getLogo());
        companyUpdate.setFoundationDate(company.getFoundationDate());
        companyUpdate.setFounder(company.getFounder());
        return companyRepository.save(companyUpdate);
    }

    @Override
    public void delete(String name) throws NoSuchObjectException {
        var companyDelete = companyRepository.findByName(name).orElseThrow(()-> new NoSuchObjectException("Company not found"));
        companyRepository.delete(companyDelete);
    }
}

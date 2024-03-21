package ar.com.laboratory.companiescrud.services.impl;

import ar.com.laboratory.companiescrud.models.dtos.CompanyDTO;
import ar.com.laboratory.companiescrud.models.enums.Category;
import ar.com.laboratory.companiescrud.models.mappers.CompanyMapper;
import ar.com.laboratory.companiescrud.repositories.CompanyRepository;
import ar.com.laboratory.companiescrud.services.CompanyService;
import ar.com.laboratory.companiescrud.util.exceptions.RecordNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Objects;

import static ar.com.laboratory.companiescrud.util.Constants.TABLE_COMPANY;


@Transactional
@Service
@AllArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private CompanyMapper companyMapper;

    @Override
    public CompanyDTO readByName(String name) throws RecordNotFoundException {
        var company = companyRepository.findByName(name).orElseThrow(()-> new RecordNotFoundException(TABLE_COMPANY));
        return companyMapper.toDto(company);
    }

    @Override
    public List<CompanyDTO> getAll() throws NoSuchObjectException {
        return  companyMapper.toDtoList(companyRepository.findAll());
    }

    @Override
    public CompanyDTO created(CompanyDTO company) {
        company.getWebsites().forEach(website -> {
            if (Objects.isNull(website)) {
                website.setCategory(Category.NONE);
            }
        });
        var companyToSave = companyMapper.toEntity(company);
        return companyMapper.toDto(companyRepository.save(companyToSave));
    }

    @Override
    public CompanyDTO update(CompanyDTO company, String name) throws RecordNotFoundException {
        var companyUpdate = companyRepository.findByName(name).orElseThrow(()-> new RecordNotFoundException(TABLE_COMPANY));
        companyUpdate.setLogo(company.getLogo());
        companyUpdate.setFoundationDate(company.getFoundationDate());
        companyUpdate.setFounder(company.getFounder());
        return companyMapper.toDto(companyRepository.save(companyUpdate));
    }

    @Override
    public void delete(String name) throws RecordNotFoundException {
        var companyDelete = companyRepository.findByName(name).orElseThrow(()-> new RecordNotFoundException(TABLE_COMPANY));
        companyRepository.delete(companyDelete);
    }
}

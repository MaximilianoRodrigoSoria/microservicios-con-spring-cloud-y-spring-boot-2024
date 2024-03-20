package ar.com.laboratory.companiescrud.services;

import ar.com.laboratory.companiescrud.models.dtos.CompanyDTO;
import ar.com.laboratory.companiescrud.models.entities.Company;

import java.rmi.NoSuchObjectException;
import java.util.List;

public interface CompanyService {
    CompanyDTO readByName(String name) throws NoSuchObjectException;
    List<CompanyDTO> getAll() throws NoSuchObjectException;
    CompanyDTO created(CompanyDTO company);
    CompanyDTO update(CompanyDTO company, String name) throws NoSuchObjectException;
    void delete(String name) throws NoSuchObjectException;
}

package ar.com.laboratory.companiescrud.services;

import ar.com.laboratory.companiescrud.entities.Company;

import java.rmi.NoSuchObjectException;

public interface CompanyService {
    Company readByName(String name) throws NoSuchObjectException;
    Company created(Company company);
    Company update(Company company, String name) throws NoSuchObjectException;
    void delete(String name) throws NoSuchObjectException;
}

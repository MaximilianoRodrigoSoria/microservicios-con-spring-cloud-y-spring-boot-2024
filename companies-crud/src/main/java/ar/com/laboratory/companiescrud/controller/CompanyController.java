package ar.com.laboratory.companiescrud.controller;

import ar.com.laboratory.companiescrud.models.dtos.CompanyDTO;
import ar.com.laboratory.companiescrud.models.entities.Company;
import ar.com.laboratory.companiescrud.services.CompanyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.rmi.NoSuchObjectException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path="/api/v1/company")
@Slf4j
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("/{name}")
    public ResponseEntity<CompanyDTO> get(@PathVariable String name) throws NoSuchObjectException {
        log.info("GET company: {}", name);
        return ResponseEntity.ok(companyService.readByName(name));
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAll() throws NoSuchObjectException {
        log.info("GET All");
        return ResponseEntity.ok(companyService.getAll());
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> post(@RequestBody CompanyDTO company){
        log.info("POST company: {}", company.getName());
        return ResponseEntity.created(URI.create(companyService.created(company).getName())).build();
    }

    @PutMapping ("/{name}")
    public ResponseEntity<CompanyDTO> put(@RequestBody CompanyDTO company,@PathVariable String name) throws NoSuchObjectException {
        log.info("PUT company: {}", name);
        return ResponseEntity.ok(companyService.update(company, name));
    }

    @DeleteMapping ("/{name}")
    public ResponseEntity<?> delete(@PathVariable String name) throws NoSuchObjectException {
        log.info("DELETE company: {}", name);
        companyService.delete(name);
        return ResponseEntity.noContent().build();
    }
}

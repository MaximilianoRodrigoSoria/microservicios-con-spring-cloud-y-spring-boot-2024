package ar.com.laboratory.companiescrud.controller;

import ar.com.laboratory.companiescrud.entities.Company;
import ar.com.laboratory.companiescrud.services.CompanyService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.rmi.NoSuchObjectException;

@RestController
@AllArgsConstructor
@RequestMapping(path="/api/v1/company")
@Slf4j
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("/{name}")
    public ResponseEntity<Company> get(@PathVariable String name) throws NoSuchObjectException {
        log.info("GET company: {}", name);
        return ResponseEntity.ok(companyService.readByName(name));
    }

    @PostMapping
    public ResponseEntity<Company> post(@RequestBody Company company){
        log.info("POST company: {}", company.getName());
        return ResponseEntity.created(URI.create(companyService.created(company).getName())).build();
    }

    @PutMapping ("/{name}")
    public ResponseEntity<Company> put(@RequestBody Company company,@PathVariable String name) throws NoSuchObjectException {
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

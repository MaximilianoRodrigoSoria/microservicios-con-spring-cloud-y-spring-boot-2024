package ar.com.laboratory.reportms.clients;


import ar.com.laboratory.reportms.models.dtos.CompanyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="companies-crud", url = "http://localhost:8081/companies-crud")
public interface CompaniesClient {
    @GetMapping("/api/v1/company/{name}")
    Optional<CompanyDTO>  get(@PathVariable String name) ;
}

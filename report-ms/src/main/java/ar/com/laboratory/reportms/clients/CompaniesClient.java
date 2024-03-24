package ar.com.laboratory.reportms.clients;


import ar.com.laboratory.reportms.configs.LoadBalancerConfigurations;
import ar.com.laboratory.reportms.models.dtos.CompanyDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "companies-crud")
@LoadBalancerClient(name = "companies-crud", configuration = LoadBalancerConfigurations.class)
public interface CompaniesClient {

    @GetMapping("/api/v1/companies-crud/{name}")
    Optional<CompanyDTO>get(@PathVariable String name);
}

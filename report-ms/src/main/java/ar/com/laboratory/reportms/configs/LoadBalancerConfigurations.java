package ar.com.laboratory.reportms.configs;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@Slf4j
public class LoadBalancerConfigurations {

@Bean
public ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context){
    log.info("Estamos configurando el loadbalancer");
    return  ServiceInstanceListSupplier
            .builder()
            .withBlockingDiscoveryClient()
            .withSameInstancePreference()
            .build(context);
}
}

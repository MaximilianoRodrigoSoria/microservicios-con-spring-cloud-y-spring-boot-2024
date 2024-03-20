package ar.com.laboratory.companiescrud.repositories;

import ar.com.laboratory.companiescrud.entities.Website;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteRepository extends JpaRepository<Website,Long> {
}

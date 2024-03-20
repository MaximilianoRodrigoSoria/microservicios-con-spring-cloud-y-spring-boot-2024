package ar.com.laboratory.companiescrud.repositories;

import ar.com.laboratory.companiescrud.models.entities.Website;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteRepository extends JpaRepository<Website,Long> {
}

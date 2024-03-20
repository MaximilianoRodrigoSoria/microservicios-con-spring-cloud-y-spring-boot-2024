package ar.com.laboratory.companiescrud.models.mappers;

import ar.com.laboratory.companiescrud.models.dtos.CompanyDTO;
import ar.com.laboratory.companiescrud.models.entities.Company;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = WebSiteMapper.class)
public interface CompanyMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "founder", target = "founder"),
            @Mapping(source = "logo", target = "logo"),
            @Mapping(source = "foundationDate", target = "foundationDate"),
            @Mapping(source = "websites", target = "websites")
    })
    CompanyDTO toDto(Company entity);

    @InheritConfiguration
    Company toEntity(CompanyDTO dto);

    List<CompanyDTO> toDtoList(List<Company> entities);

    List<Company> toEntityList(List<CompanyDTO> dtos);


}
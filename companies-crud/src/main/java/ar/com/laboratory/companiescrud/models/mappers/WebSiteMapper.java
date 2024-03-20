package ar.com.laboratory.companiescrud.models.mappers;
import ar.com.laboratory.companiescrud.models.dtos.CompanyDTO;
import ar.com.laboratory.companiescrud.models.dtos.WebsiteDTO;
import ar.com.laboratory.companiescrud.models.entities.Company;
import ar.com.laboratory.companiescrud.models.entities.Website;
import ar.com.laboratory.companiescrud.models.enums.Category;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface WebSiteMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "category", target = "category"),
            @Mapping(source = "description", target = "description")
    })
    WebsiteDTO toDto(Website entity);

    @InheritConfiguration
    Website toEntity(WebsiteDTO dto);

    Iterable<WebsiteDTO> toDtoList(Iterable<Website> entities);

    Iterable<Website> toEntityList(Iterable<WebsiteDTO> dtos);

    default String mapCategory(Category category) {
        return category != null ? category.name() : null;
    }

    default Category mapCategory(String category) {
        return category != null ? Category.valueOf(category) : null;
    }
}
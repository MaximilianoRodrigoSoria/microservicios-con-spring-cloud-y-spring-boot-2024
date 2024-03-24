package ar.com.laboratory.reportms.models.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Data
public class CompanyDTO implements Serializable {

    private Long id;
    private String name;
    private String logo;
    private String founder;
    private LocalDate foundationDate;
    private List<WebsiteDTO> websites;
}

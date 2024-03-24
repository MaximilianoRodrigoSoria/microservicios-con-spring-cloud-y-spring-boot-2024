package ar.com.laboratory.reportms.models.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Data
public class CompanyDTO implements Serializable {

    @Schema(description = "Unique website identifier", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "Name for website", example = "Facebook")
    private String name;
    @Schema(description = "Website logo", example = "facebook.jpg")
    private String logo;
    @Schema(description = "Founder name", example = "Mark Zuckerberg")
    private String founder;
    @Schema(description = "Foundation date", example = "2004-02-04")
    private LocalDate foundationDate;
    private List<WebsiteDTO> websites;
}

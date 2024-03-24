package ar.com.laboratory.reportms.models.dtos;


import ar.com.laboratory.reportms.models.enums.Category;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

import java.io.Serializable;


@Data
public class WebsiteDTO implements Serializable {
    @Schema(description = "Unique website identifier", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Schema(description = "Name for website", example = "Facebook")
    private String name;
    @Schema(description = "Categories for Websites", example = "SOCIAL_NETWORK", allowableValues = {"SOCIAL_NETWORK, SERVICES, STREAMING, CLOUD_COMPUTING, DEVICES, EDUCATION, NONE"})
    private Category category;
    @Schema(description = "Description for Website", example = "Is an American online social media and social networking service owned by Facebook, Inc.")
    private String description;

}

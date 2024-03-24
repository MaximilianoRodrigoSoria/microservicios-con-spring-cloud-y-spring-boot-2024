package ar.com.laboratory.reportms.models.dtos;


import ar.com.laboratory.reportms.models.enums.Category;
import lombok.Data;

import java.io.Serializable;


@Data
public class WebsiteDTO implements Serializable {
    private Long id;
    private String name;
    private Category category;
    private String description;

}

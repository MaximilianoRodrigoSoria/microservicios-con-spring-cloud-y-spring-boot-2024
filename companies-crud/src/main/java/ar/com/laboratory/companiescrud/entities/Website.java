package ar.com.laboratory.companiescrud.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Website implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;
    private String description;

}
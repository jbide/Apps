package fr.jyb.app.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Getter
@Setter
public class FamilleArticleResponseDTO {

    @JsonProperty(value = "id")
    private Integer id;

    /* */
    @JsonProperty(value = "nom")
    private String nom;

    /* */
    @JsonProperty(value = "description")
    private String description;
}

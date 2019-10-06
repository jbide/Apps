package fr.jyb.app.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@Getter
@Setter
public class ArticleResponseDTO {

    @JsonProperty(value = "id")
    private Integer id;

    /* */
    @JsonProperty(value = "nom")
    private String nom;

    /* */
    @JsonProperty(value = "reference")
    private String reference;

    /* */
    @JsonProperty(value = "couleur")
    private String couleur;

    /* */
    @JsonProperty(value = "description")
    private String description;

}

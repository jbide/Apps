package fr.jyb.app.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


/**
 *
 */
@Getter
@Setter
public class TourneeResponseDTO {


    @JsonProperty(value = "idTournee")
    private Integer idTournee;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "status")
    private String status;

    private ErrorDTO errorDTO;
}

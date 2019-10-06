package fr.jyb.app.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 *
 */
@Getter
@Setter
public class TourneeDTO {

    @JsonProperty(value = "idTournee")
    private Integer idTournee;

    @JsonProperty(value = "title")
    @NotNull(message="TourneeDTO - title should not be empty")
    private String title;

    @JsonProperty(value = "status")
    @NotNull(message="TourneeDTO - Status should not be empty")
    private String status;

}

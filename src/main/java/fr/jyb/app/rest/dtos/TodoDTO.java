package fr.jyb.app.rest.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TodoDTO {
    @NotNull(message = "Error in todo - Id should not be empty")
    @JsonProperty("id")
    private int id;

    @NotNull(message = "Error in todo - Name should not be empty")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "Error in todo - Description should not be empty")
    @JsonProperty("description")
    private String description;
}

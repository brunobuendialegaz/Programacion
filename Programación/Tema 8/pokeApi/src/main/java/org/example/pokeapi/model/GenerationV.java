package org.example.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenerationV {
    @JsonProperty("black-white")
    private Sprites blackWhite;
}

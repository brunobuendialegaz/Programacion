package org.example.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenerationI {
    @JsonProperty("red-blue")
    private RedBlue redBlue;
    private RedBlue yellow;
}

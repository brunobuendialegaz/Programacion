package org.example.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenerationIx {
    @JsonProperty("scarlet-violet")
    private DreamWorld scarletViolet;
}

package org.example.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenerationViii {
    @JsonProperty("brilliant-diamond-shining-pearl")
    private DreamWorld brilliantDiamondShiningPearl;
    private DreamWorld icons;
}

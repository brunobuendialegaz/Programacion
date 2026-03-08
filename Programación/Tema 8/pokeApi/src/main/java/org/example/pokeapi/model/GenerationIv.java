package org.example.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenerationIv {
    @JsonProperty("diamond-pearl")
    private Sprites diamondPearl;
    @JsonProperty("heartgold-soulsilver")
    private Sprites heartgoldSoulsilver;
    private Sprites platinum;
}

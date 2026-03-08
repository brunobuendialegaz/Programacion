package org.example.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GenerationIii {
    private OfficialArtwork emerald;
    @JsonProperty("firered-leafgreen")
    private Gold fireredLeafgreen;
    @JsonProperty("ruby-sapphire")
    private Gold rubySapphire;
}

package org.example.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Other {
    private DreamWorld dreamWorld;
    private Home home;
    @JsonProperty("official-artwork")
    private OfficialArtwork officialArtwork;
    private Sprites showdown;
}

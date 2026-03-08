package org.example.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ability {
    private Species ability;
    private boolean isHidden;
    private long slot;
}

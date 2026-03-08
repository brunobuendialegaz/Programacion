package org.example.pokeapi.model;

import lombok.Data;

import java.util.List;

@Data
public class PastAbility {
    private List<Ability> abilities;
    private Species generation;
}

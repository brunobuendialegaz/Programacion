// Pokemon.java

package org.example.pokeapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Pokemon {
    private List<Ability> abilities;
    private long baseExperience;
    private Cries cries;
    private List<Species> forms;
    private List<GameIndex> gameIndices;
    private long height;
    private List<Object> heldItems;
    private long id;
    private boolean isDefault;
    private String locationAreaEncounters;
    private List<Move> moves;
    private String name;
    private long order;
    private List<PastAbility> pastAbilities;
    private List<PastStat> pastStats;
    private List<Object> pastTypes;
    private Species species;
    private Sprites sprites;
    private List<Stat> stats;
    private List<Type> types;
    private long weight;
}


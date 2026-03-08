package org.example.pokeapi.model;

import lombok.Data;

@Data
public class Stat {
    private long baseStat;
    private long effort;
    private Species stat;
}

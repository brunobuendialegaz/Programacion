package org.example.pokeapi.model;

import lombok.Data;

import java.util.List;

@Data
public class PastStat {
    private Species generation;
    private List<Stat> stats;
}

package org.example.pokeapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Move {
    private Species move;
    private List<VersionGroupDetail> versionGroupDetails;
}

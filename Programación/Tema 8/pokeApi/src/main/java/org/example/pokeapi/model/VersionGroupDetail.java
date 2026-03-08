package org.example.pokeapi.model;

import lombok.Data;

@Data
public class VersionGroupDetail {
    private long levelLearnedAt;
    private Species moveLearnMethod;
    private Long order;
    private Species versionGroup;
}

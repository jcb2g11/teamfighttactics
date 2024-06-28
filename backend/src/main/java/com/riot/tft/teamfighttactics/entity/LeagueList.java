package com.riot.tft.teamfighttactics.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueList {

    private List<LeagueItem> entries;
    private String leagueId;
    private String tier;
    private String name;
    private String queue;
}

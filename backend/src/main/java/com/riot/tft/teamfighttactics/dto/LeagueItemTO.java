package com.riot.tft.teamfighttactics.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueItemTO {

  private String summonerId;
  private int losses;
  private int leaguePoints;
  private int profileIconId;
  private String gameName;
  private String tagLine;
  private int wins;

}

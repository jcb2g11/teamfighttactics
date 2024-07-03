package com.riot.tft.teamfighttactics.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Summoner {

  private String accountId;
  private int profileIconId;
  private String id;
  private String puuid;
  private long summonerLevel;
}

package com.riot.tft.teamfighttactics.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

  private String puuid;
  private String gameName;
  private String tagLine;
}

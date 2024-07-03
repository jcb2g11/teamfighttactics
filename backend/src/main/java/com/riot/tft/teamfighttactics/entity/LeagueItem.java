package com.riot.tft.teamfighttactics.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * The type League item.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueItem implements Comparable<LeagueItem> {

  private boolean freshBlood;
  private int wins;
  private boolean inactive;
  private boolean veteran;
  private boolean hotStreak;
  private String rank;
  private int leaguePoints;
  private int losses;
  private String summonerId;

  // Implement compareTo method to compare LeagueItems based on leaguePoints
  @Override
  public int compareTo(LeagueItem o) {
    // Compare leaguePoints in descending order
    return Integer.compare(o.getLeaguePoints(), this.getLeaguePoints());
  }
}

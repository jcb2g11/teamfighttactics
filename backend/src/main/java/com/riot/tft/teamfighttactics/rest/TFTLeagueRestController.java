package com.riot.tft.teamfighttactics.rest;


import com.riot.tft.teamfighttactics.dto.LeagueItemTO;
import com.riot.tft.teamfighttactics.entity.Account;
import com.riot.tft.teamfighttactics.entity.LeagueItem;
import com.riot.tft.teamfighttactics.entity.LeagueList;
import com.riot.tft.teamfighttactics.entity.Summoner;
import com.riot.tft.teamfighttactics.service.TFTLeagueService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TFTLeagueRestController {

  private final TFTLeagueService tftLeagueService;

  public TFTLeagueRestController(TFTLeagueService tftLeagueService) {
    this.tftLeagueService = tftLeagueService;
  }

  @GetMapping("/challengers")
  public List<LeagueItemTO> getChallengers() {
    List<LeagueItemTO> leagueItemTOList = new ArrayList<>();
    try {
      LeagueList theLeagueList = tftLeagueService.getChallengers();
      // Sort entries based on leaguePoints
      theLeagueList.sortEntriesByLeaguePoints();

      for (LeagueItem leagueItem : theLeagueList.getEntries()) {
        if (leagueItemTOList.size() <= 15) {
          Summoner summoner = tftLeagueService.getSummoner(leagueItem.getSummonerId());
          Account account = tftLeagueService.getAccount(summoner.getPuuid());
          LeagueItemTO leagueItemTO = LeagueItemTO.builder()
            .summonerId(summoner.getId())
            .wins(leagueItem.getWins())
            .losses(leagueItem.getLosses())
            .gameName(account.getGameName())
            .tagLine(account.getTagLine())
            .profileIconId(summoner.getProfileIconId())
            .leaguePoints(leagueItem.getLeaguePoints())
            .build();
          leagueItemTOList.add(leagueItemTO);
        }
      }
    } catch (Exception e) {
      // Proper exception handling, log or propagate as needed
      e.printStackTrace();
      // Optionally, throw a custom exception or return an error response
      // throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to fetch data", e);
    }

    return leagueItemTOList;
  }
}

package com.riot.tft.teamfighttactics.rest;


import com.riot.tft.teamfighttactics.entity.LeagueList;
import com.riot.tft.teamfighttactics.service.TFTLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TFTLeagueRestController {

    private final TFTLeagueService tftLeagueService;

    // Inject Employee DAO
    @Autowired
    public TFTLeagueRestController(TFTLeagueService tftLeagueService) {
        this.tftLeagueService = tftLeagueService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/challengers")
    public LeagueList getChallengers() throws Exception {
        return tftLeagueService.getChallengers();
    }
}

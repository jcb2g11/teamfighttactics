package com.riot.tft.teamfighttactics.service;

import com.riot.tft.teamfighttactics.entity.Account;
import com.riot.tft.teamfighttactics.entity.LeagueList;
import com.riot.tft.teamfighttactics.entity.Summoner;

public interface TFTLeagueService {

  LeagueList getTierData(String tier) throws Exception;

  Account getAccount(String puuid) throws Exception;

  Summoner getSummoner(String summonerId) throws Exception;
}

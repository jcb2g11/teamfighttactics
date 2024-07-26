package com.riot.tft.teamfighttactics.service;


import com.riot.tft.teamfighttactics.entity.Account;
import com.riot.tft.teamfighttactics.entity.LeagueList;
import com.riot.tft.teamfighttactics.entity.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class TFTLeagueServiceImpl implements TFTLeagueService {

  @Value("${riot.api.key}")
  private String apiKey;

  private final RestTemplate restTemplate;

  @Autowired
  public TFTLeagueServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  private <T> T performGetRequest(String url, Class<T> responseType) throws Exception {
    try {
      ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, responseType);
      return responseEntity.getBody();
    } catch (HttpStatusCodeException e) {
      throw new Exception(e.getMessage());
    }
  }

  @Override
  public LeagueList getChallengers() throws Exception {
    String url = "https://euw1.api.riotgames.com/tft/league/v1/challenger?queue=RANKED_TFT&api_key=" + apiKey;
    return performGetRequest(url, LeagueList.class);
  }

  @Override
  public Account getAccount(String puuid) throws Exception {
    String url = "https://europe.api.riotgames.com/riot/account/v1/accounts/by-puuid/" + puuid + "?api_key=" + apiKey;
    return performGetRequest(url, Account.class);
  }

  @Override
  public Summoner getSummoner(String encryptedSummonerId) throws Exception {
    String url = "https://euw1.api.riotgames.com/tft/summoner/v1/summoners/" + encryptedSummonerId + "?api_key=" + apiKey;
    return performGetRequest(url, Summoner.class);
  }
}

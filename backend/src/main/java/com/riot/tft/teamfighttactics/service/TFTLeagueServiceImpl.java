package com.riot.tft.teamfighttactics.service;


import com.riot.tft.teamfighttactics.entity.LeagueList;
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


    public LeagueList getChallengers() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<LeagueList> responseEntity;

        HttpEntity<String> requestEntity  = new HttpEntity<>(null, null);


        String url = "https://euw1.api.riotgames.com/tft/league/v1/challenger?queue=RANKED_TFT&api_key=" + apiKey;

        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, LeagueList.class);

        } catch (HttpStatusCodeException e ) {
            throw new Exception(e.getMessage());

        }
        return responseEntity.getBody();
    }
}
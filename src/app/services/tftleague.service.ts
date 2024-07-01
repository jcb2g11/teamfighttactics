import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface LeagueList {
  leagueId: string;
  tier: string;
  name: string;
  queue: string;
  entries: LeagueItem[];
}

interface LeagueItem {
  summonerId: string;
  summonerName: string;
  leaguePoints: number;
  rank: string;
  wins: number;
  losses: number;
}

@Injectable({
  providedIn: 'root'
})
export class TftLeagueService {
  private apiUrl = 'http://localhost:8080/api/v1/challengers'; // Your Spring Boot API URL

  constructor(private http: HttpClient) { }

  getChallengers(): Observable<LeagueList> {
    return this.http.get<LeagueList>(this.apiUrl);
  }
}
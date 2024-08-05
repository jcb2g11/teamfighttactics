import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { LeagueItemTO } from '../model/league-item-to.model';


@Injectable({
  providedIn: 'root'
})
export class TftLeagueService {
  private apiUrl = environment.apiUrl; // Use the environment variable

  constructor(private http: HttpClient) { }

  getChallengers(): Observable<LeagueItemTO[]> {
    return this.http.get<LeagueItemTO[]>(`${this.apiUrl}/api/v1/challengers`);
  }

  getTierData(tier: string): Observable<LeagueItemTO[]> {
    const lowerCaseTier = tier.toLowerCase();
    return this.http.get<LeagueItemTO[]>(`${this.apiUrl}/api/v1/tier/${lowerCaseTier}`);
  }
}
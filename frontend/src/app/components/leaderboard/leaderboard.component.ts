import { Component, OnInit } from '@angular/core';
import { TftLeagueService } from '../../services/tftleague.service';
import { LeagueItemTO } from '../../model/league-item-to.model';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrl: './leaderboard.component.css'
})
export class LeaderboardComponent implements OnInit {
  leagueList!: LeagueItemTO[];

  constructor(private leagueService: TftLeagueService) { }

  ngOnInit(): void {
    this.leagueService.getChallengers().subscribe(data => {
      this.leagueList = data;
    });
  }
}
import { Component, OnInit } from '@angular/core';
import { TftLeagueService } from '../../services/tftleague.service';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrl: './leaderboard.component.css'
})
export class LeaderboardComponent implements OnInit {
  leagueList: any;

  constructor(private leagueService: TftLeagueService) { }

  ngOnInit(): void {
    this.leagueService.getChallengers().subscribe(data => {
      this.leagueList = data;
    });
  }
}
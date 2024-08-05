import { Component } from '@angular/core';
import { TftLeagueService } from '../../services/tftleague.service';
import { LeagueItemTO } from '../../model/league-item-to.model';

@Component({
  selector: 'app-tiertabs',
  templateUrl: './tiertabs.component.html',
  styleUrl: './tiertabs.component.css'
})
export class TiertabsComponent {

  tiers = ['Challenger', 'GrandMaster', 'Master'];
  activeTier = 'Challenger';
  leagueList: LeagueItemTO[] = [];
  isLoading = false;


  constructor(private rpcService: TftLeagueService) {
    this.loadTierData(this.activeTier);
  }

  loadTierData(tier: string) {
    this.isLoading = true;
    this.rpcService.getTierData(tier).subscribe(data => {
      this.leagueList = data;
      this.isLoading = false;
    }, error => {
      this.isLoading = false;
      console.error("Failed to load data", error);
    });
  }

  onTierTabClick(tier: string) {
    this.activeTier = tier;
    this.loadTierData(tier);
  }

}
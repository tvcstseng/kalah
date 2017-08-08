import { Component, OnInit } from '@angular/core';
import {GameService} from "../game.service";
import {Game} from "../dto/game";
import {GameSubscription} from "../dto/game-subscription";
import {subscribeOn} from "rxjs/operator/subscribeOn";
import {Player} from "../dto/player";
import {GameState} from "../dto/game-state";
import {KalaGame} from "../dto/kala-game";

@Component({
  selector: 'app-games-overview',
  templateUrl: './games-overview.component.html',
  styleUrls: ['./games-overview.component.css']
})
export class GamesOverviewComponent implements OnInit {

  // Subscription status
  public playing: boolean;
  selectedGame: Game;
  games: Game[];
  gameSubscription: GameSubscription;
  gamestate: GameState;

  constructor(private service: GameService) { }

  ngOnInit() {
    this.service.getGames().subscribe(games => this.games = games);
  }

  subscribe() {
    this.service.subscribe(this.gameSubscription).subscribe(state => this.gamestate = state);
  }

  create(){
    this.service.create(this.selectedGame).subscribe( game => this.selectedGame = game);
  }

  valueChanged(event) {
    if ('title' === event.target.name) {
      this.selectedGame.title = event.target.value;
    } else if ('username' === event.target.name) {
      this.selectedGame.player1 = event.target.value;
    }
  }

}

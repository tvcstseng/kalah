import {Injectable} from '@angular/core';
import {Http, Response} from "@angular/http";
import {Game} from "./dto/game";
import {Observable} from "rxjs/Observable";
import {Environments} from "./environment";
import {GameSubscription} from "./dto/game-subscription";
import {GameState} from "./dto/game-state";

@Injectable()
export class GameService {

  errorMessage: string;
  games: Game[];
  subscribedGame: Game;

  constructor(private http: Http) {
  }

  getGames(): Observable<Game[]> {
    return this.http.get(Environments.URL_GAMES)
      .map(this.extractData)
      .catch(error => this.handleError(error, this))
      .map(games => this.games = games);
  }

  create(game: Game): Observable<Game> {
    return this.http.post(Environments.URL_GAMES, game)
      .map(this.extractData)
      .catch(error => this.handleError(error, this))
      .map(game => this.subscribedGame = game);
  }

  subscribe(subscription: GameSubscription): Observable<GameState> {
    return this.http.post(Environments.URL_GAMES, subscription)
      .map(this.extractData)
      .catch(error => this.handleError(error, this))
      .map(game => this.subscribedGame = game);
  }

  public handleError(error: any, service: GameService) {
    const errMsg = (error.message) ? error.message :
      error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    console.error(errMsg); // log to console instead
    service.errorMessage = errMsg;
    return Observable.throw(errMsg);
  }

  private extractData(res: Response) {
    const body = res.json();
    return body || {};
  }
}

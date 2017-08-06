import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AlertModule} from 'ngx-bootstrap';
import {ButtonModule, InputTextModule} from 'primeng/primeng';
import {AppComponent} from './app.component';
import {KalahGameComponent} from './kalah-game/kalah-game.component';
import {KalahGameService} from './kalah-game/kalah-game.service';
import {EmitterService} from './emitter.service';
import {UserComponent} from './user/user.component';
import {UserService} from './user/user.service';
import {StompConfig, StompService} from '@stomp/ng2-stompjs';
import * as SockJS from 'sockjs-client';
import {RawDataComponent} from './rawdata/rawdata.component';
import {StatusComponent} from './status/status.component';
import {GamesOverviewComponent} from "./games-overview/games-overview.component";

export function socketProvider() {
  return new SockJS('/chat');
}

const stompConfig: StompConfig = {
  // Which server?
  //url: '/chat', //'ws://127.0.0.1:8080',

  url: socketProvider,

  // Headers
  // Typical keys: login, passcode, host
  headers: {
    login: 'guest',
    passcode: 'guest'
  },

  // How often to heartbeat?
  // Interval in milliseconds, set to 0 to disable
  heartbeat_in: 0, // Typical value 0 - disabled
  heartbeat_out: 20000, // Typical value 20000 - every 20 seconds

  // Wait in milliseconds before attempting auto reconnect
  // Set to 0 to disable
  // Typical value 5000 (5 seconds)
  reconnect_delay: 30000,

  // Will log diagnostics on console
  debug: true
};

@NgModule({
  declarations: [
    AppComponent
    , KalahGameComponent
    , UserComponent
    , RawDataComponent
    , StatusComponent, GamesOverviewComponent
  ],
  imports: [
    AlertModule.forRoot()
    , BrowserModule
    , FormsModule
    , HttpModule
    , ButtonModule
    , InputTextModule
  ],
  providers: [
    KalahGameService,
    EmitterService,
    UserService,
    StompService,
    {
      provide: StompConfig,
      useValue: stompConfig
    }],
  bootstrap: [AppComponent]
})
export class AppModule {
}

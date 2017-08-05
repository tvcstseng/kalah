import {Injectable} from '@angular/core';
import {Http, Response} from "@angular/http";
import {Environments} from "../environment";
import {Observable} from "rxjs/Observable";
import {CustodianDataDto} from "../dto/custodian-data-dto";
import "rxjs/add/operator/catch";

@Injectable()
export class KalahGameService {

  private conversionUrl = Environments.URL_PREFIX + '/rest/convert/';
  errorMessage: string;
  warnMessage: string;
  custodianData: CustodianDataDto;

  constructor(public http: Http) {
  }

  getCustionData(): Observable<string> {
    return this.http.get(Environments.URL_PREFIX + '/rest/custodiandata')
      .map(this.extractData)
      .catch(error => this.handleError(error, this))
      .map(userInfoDto => this.custodianData = userInfoDto);
  }

  public handleError(error: any, service: KalahGameService) {
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

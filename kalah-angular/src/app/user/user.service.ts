import {Http, Response, Headers, RequestOptions} from '@angular/http';

import {Observable} from 'rxjs/Rx';
import {Injectable} from '@angular/core';
import {User} from '../dto/user';

@Injectable()
export class UserService {

  private userUrl = 'http://localhost:8081/api/user';

  constructor(public http: Http) {
  }

  addUser(body: Object): Observable<User[]> {
    const bodyString = JSON.stringify(body); // Stringify payload
    const headers = new Headers({'Content-Type': 'application/json'}); // ... Set content type to JSON
    const options = new RequestOptions({headers: headers}); // Create a request option

    return this.http.post(this.userUrl, body, options) // ...using post request
      .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
      .catch((error: any) => Observable.throw(error.json().error || 'Server error')); // ...errors if any
  }

  // Update a user
  updateUser(body: Object): Observable<User[]> {
    const bodyString = JSON.stringify(body); // Stringify payload
    const headers = new Headers({'Content-Type': 'application/json'}); // ... Set content type to JSON
    const options = new RequestOptions({headers: headers}); // Create a request option

    return this.http.put(`${this.userUrl}/${body['id']}`, body, options) // ...using put request
      .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
      .catch((error: any) => Observable.throw(error.json().error || 'Server error')); // ...errors if any
  }

  // Delete a user
  removeUser(id: string): Observable<User[]> {
    return this.http.delete(`${this.userUrl}/${id}`) // ...using put request
      .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
      .catch((error: any) => Observable.throw(error.json().error || 'Server error')); // ...errors if any
  }

}

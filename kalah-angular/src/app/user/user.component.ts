import {Component, EventEmitter, Input, OnChanges} from '@angular/core';
import {User} from '../dto/user';
import {UserService} from './user.service';
import {Observable} from 'rxjs/Observable';
import {EmitterService} from '../emitter.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnChanges {

  private model = new User();
  private editing = false;

  // Input properties
  @Input() editId: string;
  @Input() listId: string;

  constructor(public service: UserService) {
  }

  valueChanged(event) {
    if ('uid' === event.target.name) {
      this.model.uid = event.target.value;
    } else if ('first_name' === event.target.name) {
      this.model.firstName = event.target.value;
    } else if ('last_name' === event.target.name) {
      this.model.lastName = event.target.value;
    } else if ('email' === event.target.name) {
      this.model.email = event.target.value;
    } else if ('photo_url' === event.target.name) {
      this.model.photoUrl = event.target.value;
    }
  }

  submit() {
    // Variable to hold a reference of addComment/updateComment
    let commentOperation: Observable<User[]>;

    if (!this.editing) {
      // Create a new comment
      commentOperation = this.service.addUser(this.model);
    } else {
      // Update an existing comment
      commentOperation = this.service.updateUser(this.model);
    }

    // Subscribe to observable
    commentOperation.subscribe(
      users => {
        // Emit list event
        EmitterService.get(this.listId).emit(users);
        // Empty model
        this.model = new User();
        // Switch editing status
        if (this.editing) {
          this.editing = !this.editing;
        }
      },
      err => {
        // Log errors if any
        console.log(err);
      });

  }

  ngOnChanges( ): void {
    // Listen to the 'edit'emitted event so as populate the model
    // with the event payload
    EmitterService.get(this.editId).subscribe((user: User) => {
      this.model = user
      this.editing = true;
    });
  }
}

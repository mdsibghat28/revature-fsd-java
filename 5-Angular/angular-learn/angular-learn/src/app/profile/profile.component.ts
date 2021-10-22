import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './model/user';
import { ProfileService } from './profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user!: User;

  constructor(private profileService: ProfileService) { }

  ngOnInit(): void {
    let observable: Observable<any> = this.profileService.getUsers();
    observable.subscribe(response => {
      this.user = response.data;
    });
  }

}

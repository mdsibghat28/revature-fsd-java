import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  usersUrl: string = "https://reqres.in/api/users/1";

  constructor(private httpClient: HttpClient) { }

  getUsers(): Observable<any> {
    console.log("Service -before calling get.");
    let observable: Observable<any> = this.httpClient.get<any>(this.usersUrl);
    console.log("Service - after calling get.");
    return observable;
  }
}

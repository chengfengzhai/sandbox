import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
    providedIn: 'root'
  })
export class LoginService{
  private loginUrl='https://steventest.condoresource.ca/api/signin';
  private httpOptions = {
      headers : new HttpHeaders({'Content-Type':'application/json'})
    };

    constructor(private httpClient : HttpClient) {};

    login(user: User) : Observable<any> {
      return this.httpClient.post<any>(this.loginUrl, user, this.httpOptions);
    }
}
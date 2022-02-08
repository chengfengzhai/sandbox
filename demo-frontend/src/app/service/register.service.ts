import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
    providedIn: 'root'
  })
export class RegisterService{
    private registerUrl='https://steventest.condoresource.ca/api/signup';
    private httpOptions = {
      headers : new HttpHeaders({'Content-Type':'application/json'})
    };

    constructor(private httpClient : HttpClient) {};

    register(user: User) : Observable<any> {
      return this.httpClient.post<any>(this.registerUrl, user, this.httpOptions);
    }
}
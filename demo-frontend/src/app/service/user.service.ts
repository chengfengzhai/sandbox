import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class UserService {
 
  private addUserUrl = 'http://150.230.30.7/registration';
  constructor(private http : HttpClient) {  }

  public saveUser(user: any){
    return this.http.post<any>(this.addUserUrl, user);
  }

  
}

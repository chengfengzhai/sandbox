import { Injectable } from '@angular/core';
import { User } from '../model/user';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  signOut() {
    window.sessionStorage.clear();
  }

  public saveToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string | null {
    //  let token = sessionStorage.getItem(TOKEN_KEY);
    //  if(token != null){
    //      return token;
    //  }else{
    //      return null;
    //  }
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user : User) {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser() : User | null {
    let userStr = sessionStorage.getItem(USER_KEY);
    if (userStr != null){
        return JSON.parse(userStr);
    }else{
        return null;
    }
    //return JSON.parse(sessionStorage.getItem(USER_KEY));
  }
}
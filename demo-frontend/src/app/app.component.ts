import { Component } from '@angular/core';
import { TokenStorageService } from './service/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  private roles: string[] = [];
  isLoggedIn = false;
  title = 'staticweb';
  constructor (private tokenService : TokenStorageService){}

  ngOnInit() : void {
    this.isLoggedIn = !!this.tokenService.getToken();
  }

  logout() : void {
    this.tokenService.signOut();
    window.location.reload();
  }
}

import { ApplicationRef, Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { LoginService } from '../service/login.service';
import { TokenStorageService } from '../service/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  user: User = new User();
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private loginService : LoginService, private tokenService : TokenStorageService) { }
  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.isLoggedIn = true;
      let existingUser = this.tokenService.getUser();
      if(existingUser != null){
        console.log('existing user: ' + existingUser.username);
//        this.user = existingUser;
        this.roles = existingUser.roles;
      }
              //this.roles = this.tokenService.getUser().roles;

    }
  }
  onSubmit(): void {
    this.loginService.login(this.user).subscribe(
      data => {
        this.tokenService.saveToken(data.token);
        this.tokenService.saveUser(data);
        this.roles = data.roles;
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.reloadPage();
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }
  reloadPage(): void {
    window.location.reload();
  }
}

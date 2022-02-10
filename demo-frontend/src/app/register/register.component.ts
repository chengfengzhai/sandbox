import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { RegisterService } from '../service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  user: User = new User();
  isFinished = false;
  isThereError = false;
  errorMessage = '';
  constructor(private registerService : RegisterService) { }
  ngOnInit(): void {}

  onSubmit(): void {
    this.registerService.register(this.user).subscribe(
      data => {
        console.log(data);
        this.isThereError = false;
        this.isFinished = true;
      },
      err => {
        console.log(err);
        this.errorMessage = err.error.message;
        this.isThereError = true;
      }
    );
  }

}

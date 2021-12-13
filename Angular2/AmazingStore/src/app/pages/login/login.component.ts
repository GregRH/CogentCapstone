import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor() {}
  public user = {
    id: '',
    name: '',
    email: '',
    password: '',
    dob: '',
  };

  ngOnInit(): void {}

  formSubmit() {
    console.log(this.user);
    if (this.user.name == '' || this.user.name == null) {
      alert('user name is required');
    }
  }
}

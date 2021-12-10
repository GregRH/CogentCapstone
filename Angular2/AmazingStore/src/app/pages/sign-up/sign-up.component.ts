import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css'],
})
export class SignUpComponent implements OnInit {
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

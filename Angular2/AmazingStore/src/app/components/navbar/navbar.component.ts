import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartCall } from '../cart-call';
import { Account } from '../service/account';
import { AccountService } from '../service/account.service';
import { AuthenticationService } from '../service/auth.service';
import { OrderService } from '../service/order.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  providers: [CartCall],
})
export class NavbarComponent implements OnInit {
  productsQuantity!: number;
  signedAccount!: Account;

  accountId: any = sessionStorage.getItem('id')
    ? sessionStorage.getItem('id')
    : 0;
  signedId: number = this.accountId;

  isSeller = false;
  isBuyer = false;

  constructor() {}

  ngOnInit(): void {}
}

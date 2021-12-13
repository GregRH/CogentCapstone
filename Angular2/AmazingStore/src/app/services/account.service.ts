import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AccountService {
  constructor(private http: HttpClient) {}

  private baseUrl = 'http://localhost:8080/account';
  private baseUrl2 = 'http://localhost:8080/api/accounts';
  private authUrl = 'http://localhost:8080/auth';
}

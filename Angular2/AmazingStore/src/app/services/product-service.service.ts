import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
 private baseUrl = 'http://localhost:8080/rest';
	private item={
		id:'',
		name:'',
		price:'',
		quantity:'',	
	};
  constructor(private http: HttpClient) { }
	getProductList(){
		return this.http.get(`${this.baseUrl}`);
	}
}

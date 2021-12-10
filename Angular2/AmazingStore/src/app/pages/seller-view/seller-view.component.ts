import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductServiceService } from '../../services/product-service.service';
@Component({
  selector: 'app-seller-view',
  templateUrl: './seller-view.component.html',
  styleUrls: ['./seller-view.component.css']
})
export class SellerViewComponent implements OnInit {

  constructor(private productService: ProductServiceService) { }
	public item={
		id!:'',
		name!:'',
		price!:'',
		quantity!:'',
	};
	items!: Observable<item[]>;
	formSubmit(){
		console.log(this.item);
		this.reload();
	}
  ngOnInit(): void {
	  this.reload();	
  }
	reload(){
		this.items=this.productService.getProductList();
	}

}

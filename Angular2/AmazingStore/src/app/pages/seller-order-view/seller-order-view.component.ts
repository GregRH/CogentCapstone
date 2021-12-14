import { Component, OnInit } from '@angular/core';
import { Account } from '../../services/account';
import { AccountService } from '../../services/account.service';
import { Order } from '../../services/order';
import { OrderService } from '../../services/order.service';
import { Product } from '../../services/product';
@Component({
  selector: 'app-seller-order-view',
  templateUrl: './seller-order-view.component.html',
  styleUrls: ['./seller-order-view.component.css']
})
export class SellerOrderViewComponent implements OnInit {
orders!: Order[];
  price!: number;
  totalCost: number[] = [];

  signedAccount!: Account;
  accountId: any = sessionStorage.getItem('id')
    ? sessionStorage.getItem('id')
    : 0;
  signedId: number = this.accountId;

  constructor(private os: OrderService, private as: AccountService) { }

  ngOnInit(): void {
	  this.getAccountById(this.signedId);
  }
 getAccountById(id: number) {
    this.as.getAccountById(id).subscribe((res) => {
      this.signedAccount = res;
      if (this.signedAccount.accountType.toLowerCase() === 'buyer') {
        this.getOrdersByAccountId(id);
      } else {
        this.getAllOrdrs();
      }
    });
  }

  accountTypeChecker(id: number) {}

  getOrdersByAccountId(id: number) {
    this.os.findByAccountId(id).subscribe((res) => {
      this.orders = res;
      console.log(res);
      // this.currentOrder = this.orders[this.orders.length - 1];
      // console.log(this.currentOrder);
      // this.selectedProduct = this.currentOrder.products;
      // console.log(this.selectedProduct);
      // this.getProducts(this.orders);
      // this.sumOrdersPrice(this.unPaidProducts);
    });
  }

  getAllOrdrs() {
    this.os.getAllOrders().subscribe((res) => {
      this.orders = res;
      this.getProductsPerOrder(this.orders);
    });
  }

  updateOrder(order: Order) {
    this.os.updateOrder(order.id, order).subscribe(
      (res) => console.log(res),
      (error) => console.log(error)
    );
  }
  getProductsPerOrder(orders: Order[]) {
    if (orders) {
      let products = orders.map((o) => o.products);
      console.log(products);
      products.forEach((p) => this.sumOrdersPrice(p));
    }
  }
  onSubmit(order: Order) {
    let updatedOrder = order;
    updatedOrder.shipped = true;
    this.updateOrder(updatedOrder);
  }

  sumOrdersPrice(products: Product[]) {
    const reducer = (previousValue: number, currentValue: number) =>
      previousValue + currentValue;
    let priceList: number[] = [];
    products.map((p) => priceList.push(p.productPrice));
    console.log(priceList);
    console.log(priceList.reduce(reducer));
    this.totalCost.push(priceList.reduce(reducer));
    console.log(this.totalCost);
  }}

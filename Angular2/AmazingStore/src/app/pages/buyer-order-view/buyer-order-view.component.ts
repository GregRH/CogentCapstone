import { Component, OnInit } from '@angular/core';
import { Order } from '../../services/order';
import { OrderService } from '../../services/order.service';
@Component({
  selector: 'app-buyer-order-view',
  templateUrl: './buyer-order-view.component.html',
  styleUrls: ['./buyer-order-view.component.css']
})
export class BuyerOrderViewComponent implements OnInit {
orders!: Order[];
  constructor()private os: OrderService { }

  ngOnInit(): void {
  }
getOrdersByAccountId(id: number) {
    this.os
      .findByAccountId(id)
      .subscribe((res) =>
        console.log(`Account 1 orders: ${JSON.stringify(res)}`)
      );
  }
}

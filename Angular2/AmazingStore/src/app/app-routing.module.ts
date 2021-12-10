import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SellerViewComponent } from './pages/seller-view/seller-view.component';

const routes: Routes = [
	{
		path:'rest',component: SellerViewComponent 
	},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

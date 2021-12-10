import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LeftMenuComponent } from './components/left-menu/left-menu.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BuyerViewComponent } from './pages/buyer-view/buyer-view.component';
import { SellerViewComponent } from './pages/seller-view/seller-view.component';
import { ProductDetailsComponent } from './pages/product-details/product-details.component';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';

@NgModule({
  declarations: [
    AppComponent,
    LeftMenuComponent,
    NavbarComponent,
    BuyerViewComponent,
    SellerViewComponent,
    ProductDetailsComponent,
    LoginComponent,
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

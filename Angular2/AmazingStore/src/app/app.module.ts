import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LeftMenuComponent } from './components/left-menu/left-menu.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { BuyerCartViewComponent } from './pages/buyer-cart-view/buyer-cart-view.component';
import { BuyerProductViewComponent } from './pages/buyer-product-view/buyer-product-view.component';
import { BuyerOrderViewComponent } from './pages/buyer-order-view/buyer-order-view.component';
import { SellerOrderViewComponent } from './pages/seller-order-view/seller-order-view.component';
import { SellerStockViewComponent } from './pages/seller-stock-view/seller-stock-view.component';
import { SellerAddProductComponent } from './pages/seller-add-product/seller-add-product.component';

import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { HttpInterceptorService } from './service/httpinterceptor.service';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatBadgeModule } from '@angular/material/badge';
import { MatMenuModule } from '@angular/material/menu';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { MatTableModule } from '@angular/material/table';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
@NgModule({
  declarations: [
    AppComponent,
    LeftMenuComponent,
    NavbarComponent,
    LoginComponent,
    SignUpComponent,
    BuyerCartViewComponent,
    BuyerProductViewComponent,
    BuyerOrderViewComponent,
    SellerOrderViewComponent,
    SellerStockViewComponent,
    SellerAddProductComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatAutocompleteModule,
    HttpInterceptorService,
    MatSnackBarModule,
    MatBadgeModule,
    MatMenuModule,
    MatSelectModule,
    MatFormFieldModule,
    MatDividerModule,
    MatListModule,
    MatTableModule,
    MatGridListModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatCardModule,
    MatButtonModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSliderModule,
    HttpClientModule,
    HTTP_INTERCEPTORS,
  ],
  providers: [
    //BsModalService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true,
    },
  ],

  bootstrap: [AppComponent],
})
export class AppModule {}

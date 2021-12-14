import { Category } from './category';
import { Order } from './order';

export class Product {
  id!: number;
  name!: string;
  productImageURL!: string;
  productsQuantity!: number;
  productLongDescription!: string;
  productShortDescription!: string;
  productRating!: number;
  category!: Category;
  order!: Order[];
}

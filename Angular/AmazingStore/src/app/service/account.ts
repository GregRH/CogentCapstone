import { Order } from './order';

export class Account {
  id!: number;
  fullName!: string;
  email!: string;
  password!: string;
  type!: string;
  dateOfBirth!: string;
  order!: Order[];
}

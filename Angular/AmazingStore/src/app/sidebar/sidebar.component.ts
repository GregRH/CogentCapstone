import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from '../service/category';
import { CategoryService } from '../service/category.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
})
export class SidebarComponent implements OnInit {
  categories!: Category[];
  id!: number;
  cat!:Category;
  constructor(private cs: CategoryService, private router: Router) {}
  ngOnInit(): void {
    this.getAllCategories();
    console.log(this.categories);
    console.log(this.id);
  }

  getAllCategories() {
    this.cs.getAllCategories().subscribe((res) => (this.categories = res));
  }

  handleTabClick(id: number) {
    this.getAllCategories();
    this.cat=this.categories[0];
    console.log(this.cat)
    console.log(this.categories[0].name);
    console.log(this.categories[0].id);
    console.log(id)
    id=2;
    this.router.navigate(['home', id]);
  }
}

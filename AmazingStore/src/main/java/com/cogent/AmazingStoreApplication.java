package com.cogent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cogent.bo.Category;
import com.cogent.bo.Product;
import com.cogent.dao.CategoryDAO;

	

@SpringBootApplication
public class AmazingStoreApplication implements CommandLineRunner{
	@Autowired
	private CategoryDAO catDao;
	public static void main(String[] args) {
		SpringApplication.run(AmazingStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Category c1 = new Category(); //= new Category(101,"Fruits");
		Category c2 = new Category(); //= new Category(102,"Vegetables");
		c1.setName("Honda");
		c2.setName("Dodge");
		//catDao.save(c1);
	//	catDao.save(c2);
		
		Product p1; //= new Product("Orange", "image", 0.77, 20,"1-long descrption", "5-short description", 4.8);
		Product p2; //= new Product("Apple", "image", 0.99, 280,"2-long descrption", "6-short description", 5);
		Product p3; //= new Product("Potato", "image", 1.57, 40,"3-long descrption", "7-short description", 3.8);
		Product p4;// = new Product("Carrot", "image", 2.67, 204,"4-long descrption", "8-short description", 4.4);
	}

}

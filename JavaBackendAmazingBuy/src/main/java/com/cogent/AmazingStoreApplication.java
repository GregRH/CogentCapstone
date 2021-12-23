package com.cogent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cogent.bo.Category;
import com.cogent.bo.Product;
import com.cogent.dao.CategoryDAO;
import com.cogent.dao.ProductDAO;

	

@SpringBootApplication
public class AmazingStoreApplication implements CommandLineRunner{
	@Autowired
	private CategoryDAO catDao;
	@Autowired
	private ProductDAO prodDao;
	public static void main(String[] args) {
		SpringApplication.run(AmazingStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Category c1 = new Category(); //= new Category(101,"Fruits");
		Category c2 = new Category(); //= new Category(102,"Vegetables");
		//c1.setName("Honda");
		//c2.setName("Dodge");
		//catDao.save(c1);
	//	catDao.save(c2);
		c2 = catDao.getById(2l);
		Product p1 = new Product(); //= new Product("Orange", "image", 0.77, 20,"1-long descrption", "5-short description", 4.8);
		Product p2; //= new Product("Apple", "image", 0.99, 280,"2-long descrption", "6-short description", 5);
		Product p3; //= new Product("Potato", "image", 1.57, 40,"3-long descrption", "7-short description", 3.8);
		Product p4;// = new Product("Carrot", "image", 2.67, 204,"4-long descrption", "8-short description", 4.4);
		//p1= prodDao.findByNameContaining("Challenger");
		//	p1.setImg("challenger.jpeg");
		
		/*p1.setName("Challenger");
		p1.setProductImageURL("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmedia.autoexpress.co.uk%2Fimage%2Fprivate%2Fs--Xw-N-ae7--%2Fv1575319325%2Fautoexpress%2F2019%2F11%2F197748_honda_reveals_fresh_styling_and_enhanced_interior_for_civic.jpg&f=1&nofb=1");
		p1.setProductPrice(300000);
		p1.setProductRating(5);
		p1.setProductQuantity(30);
		p1.setCategory(c2);*/
		//prodDao.save(p1);
		//p1=prodDao.findProductByName("Challenger");
		prodDao.existsById(4l);
		List<Product>prods=prodDao.findProductByName("Challenger");//prodDao.findAll();
		System.out.println(prods.get(0).getId());
		
	}

}

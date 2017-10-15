package ngoc.thach.myshoppingbackend.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ngoc.thach.myshoppingbackend.dao.ProductDAO;
import ngoc.thach.myshoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static ProductDAO productDAO;
	private static AnnotationConfigApplicationContext context;
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("ngoc.thach.shoppingbackend");
		context.refresh();
		productDAO =  (ProductDAO)context.getBean("productDAO");
	}

}

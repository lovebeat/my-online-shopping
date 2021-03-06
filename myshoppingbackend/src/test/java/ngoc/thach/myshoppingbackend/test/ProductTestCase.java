package ngoc.thach.myshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
		context.scan("ngoc.thach.myshoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	// @Test
	// public void testCRUDProduct() {
	// // create operation
	// product = new Product();
	//
	// product.setName("Oppo Selfie ss3");
	// product.setBrand("Oppo");
	// product.setDescription("This is some description");
	// product.setUnitPrice(25000);
	// product.setActive(true);
	// product.setCategoryId(3);
	// product.setSupplierId(3);
	//
	// assertEquals("Something went wrong while inserting a new product", true,
	// productDAO.add(product));
	//
	// //reading and updating the category
	// product = productDAO.get(2);
	// product.setName("Samsung galaxy s7");
	// assertEquals("Something went wrong while updating the existing record",
	// true, productDAO.update(product));
	// assertEquals("Something went wrong while deleting the existing record",
	// true, productDAO.delete(product));
	// //list
	// assertEquals("Something went wrong while fetching the list of products",
	// 7,productDAO.list().size());
	//
	//
	// }

//	@Test
//	public void testListActiveProduct() {
//		assertEquals("Something went wrong while fetching the list of products", 7,
//				productDAO.listActiveProducts().size());
//	}
//
//	@Test
//	public void testListActiveProductByCategory() {
//		assertEquals("Something went wrong while fetching the list of products", 7,
//				productDAO.listActiveProductsByCategory(3).size());
//	}

//	@Test
//	public void testUpdateProduct() {
//
//		product = productDAO.get(1);
//		product.setQuantity(0);
//		assertEquals("Successfully update category", true, productDAO.update(product));
//
//	}
	@Test
	public void testSetMaxQuery() {
		assertEquals("Successfully update category", 2, productDAO.getLimit().size());
	}

}

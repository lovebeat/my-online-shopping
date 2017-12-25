package ngoc.thach.myshoppingbackend.dao;

import java.util.List;

import ngoc.thach.myshoppingbackend.dto.Product;

public interface ProductDAO {
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	
	///business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	//this for test
	List<Product> getLimit();

}

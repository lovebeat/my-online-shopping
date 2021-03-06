package ngoc.thach.myshoppingbackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ngoc.thach.myshoppingbackend.dao.ProductDAO;
import ngoc.thach.myshoppingbackend.dto.Product;
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product", Product.class)
				.getResultList();
		
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession()
							.persist(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession()
							.update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession()
							.update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE isActive = :active";
		
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProducts, Product.class)
					.setParameter("active", true)
						.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveViaCategoryId = "FROM Product WHERE isActive= :active AND categoryId = :categoryId";
		
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveViaCategoryId, Product.class)
							.setParameter("active", true)
							.setParameter("categoryId", categoryId)
								.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE isActive = :active ORDER BY id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}
	//this for test need be deleted after
	@Override
	public List<Product> getLimit() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product", Product.class)
				.getResultList().subList(0, 1);
	}

}

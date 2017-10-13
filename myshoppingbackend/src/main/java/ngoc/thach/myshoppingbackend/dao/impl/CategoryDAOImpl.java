package ngoc.thach.myshoppingbackend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ngoc.thach.myshoppingbackend.dao.CategoryDAO;
import ngoc.thach.myshoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see ngoc.thach.myshoppingbackend.dao.CategoryDAO#get(int) getting single
	 * category based on id
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try {
			// add the category to the database
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * Updating a single category (non-Javadoc)
	 * 
	 * @see ngoc.thach.myshoppingbackend.dao.CategoryDAO#update(ngoc.thach.
	 * myshoppingbackend.dto.Category)
	 */
	@Override
	public boolean update(Category category) {
		try {
			// add the category to the database
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			// add the category to the database
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

}

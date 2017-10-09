package ngoc.thach.myshoppingbackend.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ngoc.thach.myshoppingbackend.dao.CategoryDAO;
import ngoc.thach.myshoppingbackend.dto.Category;

@Repository("categoryDao")
public class CategoryDAOImpl implements CategoryDAO {
	private static List<Category> categories = new ArrayList<Category>();
	static {
		Category category = new Category();
		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		// adding second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some description for mobile");
		category.setImageURL("CAT_2.png");
		categories.add(category);

		// adding third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some description for laptop");
		category.setImageURL("CAT_3.png");
		categories.add(category);
//		for (Category categorys : categories) {
//			System.out.println(categorys.getName());
//		}

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for (Category category : categories) {
			if(category.getId()==id)
				return category;
		}
		return null;
	}

}

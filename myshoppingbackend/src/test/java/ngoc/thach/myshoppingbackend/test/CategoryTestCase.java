package ngoc.thach.myshoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ngoc.thach.myshoppingbackend.dao.CategoryDAO;
import ngoc.thach.myshoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("ngoc.thach.myshoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	// @Test
	// public void testAddCategory() {
	// category = new Category();
	// category.setName("Laptop");
	// category.setDescription("This is some description for Laptop test 1");
	// category.setImageURL("CAT_1.png");
	// assertEquals("Successfully added a category inside the
	// table",true,categoryDAO.add(category));
	// }

	// @Test
	// public void testGetCategory() {
	// category = categoryDAO.get(4);
	// assertEquals("Succesfully get single category","Television",
	// category.getName());
	// }

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(4); category.setName("TV");
	 * assertEquals("Successfully update category", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 */
	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(100);
	 * 
	 * assertEquals("Successfully delete category", false,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	// @Test
	// public void testListCategory() {
	//
	//
	// assertEquals("Successfully fetched the list of categories", 1,
	// categoryDAO.list().size());
	//
	// }
	@Test
	public void testCRUDCategory() {
		// add category operation
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for Laptop test 1");
		category.setImageURL("CAT_1.png");
		category.setActive(true);
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Television");
		category.setDescription("This is some description for Television test 1");
		category.setImageURL("CAT_2.png");
		category.setActive(true);
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
		// fetching and updating category
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully update category", true, categoryDAO.update(category));
		// delete category
		category = categoryDAO.get(2);

		assertEquals("Successfully delete category", true, categoryDAO.delete(category));
		//fetching the list 
		assertEquals("Successfully fetched the list of categories", 1, categoryDAO.list().size());

	}
}

package ngoc.thach.myonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ngoc.thach.myshoppingbackend.dao.CategoryDAO;
import ngoc.thach.myshoppingbackend.dto.Category;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value = { "/", "/index", "/home" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		//passing the list of catefories
		mv.addObject("categories", categoryDAO.list() );
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = "contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}

//	@RequestMapping(value="/test")
//	public ModelAndView test(@RequestParam(value="greeting", required=false) String greetingVal) {
//		if (greetingVal==null) {
//			greetingVal="Hello from null";
//		}
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting",greetingVal);
//		return mv;
//	}
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greetingVal) {
		if (greetingVal==null) {
			greetingVal="Hello from null";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greetingVal);
		return mv;
	}
	/*
	 * Method to load all products based on category
	 * 
	 */
	@RequestMapping(value ="/show/all/products")
	public ModelAndView showAllProduct() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		//passing the list of catefories
		mv.addObject("categories", categoryDAO.list() );
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	@RequestMapping(value ="/show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		/// categoryDAO to fetch single category
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list() );
		//passing the single category object
		mv.addObject("category", category );

		mv.addObject("userClickCategoryProducts", true);
		System.out.println(category.getName());
		return mv;
	}
	
}

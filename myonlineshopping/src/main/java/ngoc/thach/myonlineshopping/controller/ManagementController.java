package ngoc.thach.myonlineshopping.controller;

import java.util.List;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ngoc.thach.myonlineshopping.ulti.FileUploadUtility;
import ngoc.thach.myonlineshopping.validator.ProductValidator;
import ngoc.thach.myshoppingbackend.dao.CategoryDAO;
import ngoc.thach.myshoppingbackend.dao.ProductDAO;
import ngoc.thach.myshoppingbackend.dto.Category;
import ngoc.thach.myshoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);

		mv.addObject("title", "Manage Products");

		Product nProduct = new Product();
		// set few of the fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);

		if (operation != null) {
			if (operation.equals("product")) {

				mv.addObject("message", "Product Submitted Successfully");
			}
			else if (operation.equals("category")) {

				mv.addObject("message", "Category Submitted Successfully");
			}
		}
		return mv;
	}

	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProducts", true);

		mv.addObject("title", "Manage Products");
		
		//fetch the product from database
		Product nProduct = productDAO.get(id);
		//set product fetch from database
		mv.addObject("product", nProduct);

		return mv;
	}

	// handling product submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {
		if(mProduct.getId()==0) {
			new ProductValidator().validate(mProduct, results);
		}
		else {
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}
		

		// check if there are any errors
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for Product submission!");
			return "page";
		}
		// create new product record
		if(mProduct.getId()==0) {
			//add product if id == 0
			productDAO.add(mProduct);
		}
		else {
			//update product if id is not 0
			productDAO.update(mProduct);
		}
		

		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/products?operation=product";

	}

	// this is for activation product
	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {

		// is going to fetch the product from the database
		System.out.println("/////////////////////////////////////////////////" + id);
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		// activating and deactivating based on the value of active field
		product.setActive(!product.isActive());

		productDAO.update(product);
		return (isActive) ? "You have successfully deactived the product with id " + product.getId()
				: "You have successfully actived the product with id " + product.getId();

	}
	//to handel category submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		category.setActive(true);
		categoryDAO.add(category);
		return "redirect:/manage/products?operation=category";
	}

	// return categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDAO.list();
	}
	//for add new catefory
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}

}

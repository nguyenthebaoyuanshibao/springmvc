package springmvc_example.controller;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.model.Users;
import springmvc_example.service.CategoryService;
import springmvc_example.service.ProductService;
import springmvc_example.service.UserService;
import springmvc_example.validator.SignupValidator;

@Controller
@RequestMapping("")
public class AdminController {
	
	@Autowired 
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	SignupValidator signupValidator;

	@Autowired
	UserService userService;
	
	// admin page.
	@RequestMapping(value = "user/admin", method = RequestMethod.GET)
	public ModelAndView admin_page() {

		ModelAndView model = new ModelAndView("user/admin_page");
		model.addObject("products", this.productService.getAllProducts());

		return model;
	}
	
	//list All User
	@RequestMapping(value="user/admin/listUser",method = RequestMethod.GET)
	public ModelAndView listUser() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("list", userService.getAllUser());
		model.setViewName("user/list_user");
		
		return model;
	}

	// Remove User Page.
	@RequestMapping(value = "user/admin/removeUser/{userId}", method = RequestMethod.GET)
	public ModelAndView removeUser(@PathVariable("userId") String userId) {

		ModelAndView model = new ModelAndView("user/remove_user");
		model.addObject("user", userService.findUserbyUserId(userId));

		return model;
	}

	// Remove User Success Page.
	@RequestMapping(value = "user/admin/listUser", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute("user") Users user) {

		ModelAndView model = new ModelAndView("user/list_user");
		userService.deleteUser(user.getUserId());
		model.addObject("msg", "User removed successful!");
		model.addObject("list", userService.getAllUser());

		return model;
	}

	// Add Product Page.
	@RequestMapping("/user/admin/addProduct")
	public ModelAndView addProductForm() {

		ModelAndView model = new ModelAndView();
		model.setViewName("product/add_product");

		return model;
	}

	// Add Product Result Page.
	@RequestMapping(value = "/user/admin/addProduct/add")
	public ModelAndView addProduct(@RequestParam("id") String url, @RequestParam("categoryId") String categoryId,
			@RequestParam("productName") String productName, @RequestParam("unitPrice") Integer unitPrice,
			@RequestParam("unitsInStock") Integer unitsInStock, @RequestParam("description") String description,
			@RequestParam("manufacturer") String manufacturer) {

		ModelAndView model = new ModelAndView();
		productService.addProduct(url, categoryId, productName, unitPrice, unitsInStock, description, manufacturer);
		model.addObject("msg", "Add Product Success!");
		model.addObject("products", this.productService.getAllProducts());
		model.setViewName("user/admin_page");

		return model;
	}

	// Update Product Page.
	@RequestMapping("/user/admin/updateProduct")
	public ModelAndView updateProductForm() {

		ModelAndView model = new ModelAndView();
		model.setViewName("product/update_product");

		return model;
	}

	// Update Product Result Page.
	@RequestMapping("/user/admin/updateProduct/update")
	public ModelAndView addProduct(@RequestParam("id") Integer productId, @RequestParam("url") String url,
			@RequestParam("categoryId") String categoryId, @RequestParam("productName") String productName,
			@RequestParam("unitPrice") Integer unitPrice, @RequestParam("unitsInStock") Integer unitsInStock,
			@RequestParam("description") String description, @RequestParam("manufacturer") String manufacturer) {

		ModelAndView model = new ModelAndView();
		productService.updateProduct(productId, url, categoryId, productName, unitPrice, unitsInStock, description,
				manufacturer);
		model.addObject("msg", "Update Product Success!");
		model.setViewName("product/update_product");

		return model;
	}

	// Delete Category Page.
	@RequestMapping("/user/admin/deleteCategory")
	public ModelAndView deleteCategoryForm() {

		ModelAndView model = new ModelAndView();
		model.setViewName("category/delete_category");

		return model;
	}

	// Delete Category Success Page.
	@RequestMapping("/user/admin/deleteCategory/delete")
	public ModelAndView deleteCategory(@RequestParam("id") String categoryId) {

		ModelAndView model = new ModelAndView();
		categoryService.deleteCategory(categoryId);
		model.addObject("msg", "Delete Category success!");
		model.setViewName("category/delete_category");

		return model;
	}

}

package springmvc_example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springmvc_example.model.Category;
import springmvc_example.model.Product;
import springmvc_example.model.Users;
import springmvc_example.service.CategoryService;
import springmvc_example.service.ProductService;
import springmvc_example.service.UserService;
import springmvc_example.validator.AddCategoryValidator;
import springmvc_example.validator.SignUpValidator;

@Controller
@RequestMapping("")
public class AdminController {
	
	@Autowired 
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	SignUpValidator signupValidator;

	@Autowired
	UserService userService;
	
	@Autowired
	AddCategoryValidator addCategoryValidator;
	
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
	@RequestMapping(value = "user/admin/removeUser/{userName}", method = RequestMethod.GET)
	public ModelAndView removeUser(@PathVariable("userName") String userName) {

		ModelAndView model = new ModelAndView("user/remove_user");
		model.addObject("user", userService.findUserbyUserName(userName));

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
		model.addObject("listCategory", categoryService.listCategory() );
		
		return model;
	}

	// Add Product Result Page.
	@RequestMapping(value = "/user/admin/addProduct/add",method = RequestMethod.GET)
	public String addProduct(@RequestParam("id") String url, @RequestParam("categoryId") Integer categoryId,
			@RequestParam("productName") String productName, @RequestParam("unitPrice") Integer unitPrice,
			@RequestParam("unitsInStock") Integer unitsInStock, @RequestParam("description") String description,
			@RequestParam("manufacturer") String manufacturer, Model model) {
        
		
		
		productService.addProduct(url, categoryId, productName, unitPrice, unitsInStock, description, manufacturer);
		model.addAttribute("msg", "Add Product Success!");
		model.addAttribute("products", this.productService.getAllProducts());
		

		return "redirect:/user/admin";
	}
	
	// Update Product Page.
	@RequestMapping("/user/admin/updateProduct")
	public ModelAndView updateProductForm(@RequestParam("id") Integer productId) {

		ModelAndView model = new ModelAndView();
		model.addObject("listCategory", categoryService.listCategory() );
		model.addObject("product", this.productService.getProductByProductId(productId));
		model.setViewName("product/update_product");	
		
		return model;
	}

	// Update Product Result Page.
	@RequestMapping("/user/admin/updateProduct/update")
	public String addProduct(@RequestParam("id") Integer productId, @RequestParam("url") String url,
			@RequestParam("categoryId") Integer categoryId, @RequestParam("productName") String productName,
			@RequestParam("unitPrice") Integer unitPrice, @RequestParam("unitsInStock") Integer unitsInStock,
			@RequestParam("description") String description, @RequestParam("manufacturer") String manufacturer, Model model) {
	
		productService.updateProduct(productId, url, categoryId, productName, unitPrice, unitsInStock, description,
				manufacturer);
		model.addAttribute("msg", "Update Product Success!");
		
		return "redirect:/user/admin";
	}
	
	// Delete Product .
		@RequestMapping("/user/admin/deleteProduct/")
		public String deleteProduct(@RequestParam("id") Integer productId, Model model) {

			productService.deleteProductByProductId(productId);
			model.addAttribute("msg", "Delete Product success!");
			

			return "redirect:/user/admin";
		}
	
	// Add Category Page.
		@RequestMapping("/user/admin/addCategory")
		public ModelAndView addCategoryForm() {
             
			ModelAndView model = new ModelAndView();
			List<Category> listCategory = categoryService.listCategory();
			model.addObject("listCategory", listCategory );
			model.setViewName("category/add_category");

			return model;
		}
		
		// Add Category Success Page.
		@RequestMapping("/user/admin/addCategory/add")
		public String addCategory(@RequestParam("id") String categoryName, Model model  ) {
			
			categoryService.addCategory(categoryName);
			model.addAttribute("msg", "Add Category success!");
		
			return "redirect:/user/admin";		
		}	

	// Delete Category Page.
	@RequestMapping("/user/admin/deleteCategory")
	public ModelAndView deleteCategoryForm() {

		ModelAndView model = new ModelAndView();
		List<Category> listCategory = categoryService.listCategory();
		model.addObject("listCategory", listCategory );
		for(Category category:listCategory) {
			Integer size = productService.getProductsByCategory(category.getCategoryId()).size();
			model.addObject("size", size);
		}
		model.setViewName("category/delete_category");

		return model;
	}

	// Delete Category Success Page.
	@RequestMapping("/user/admin/deleteCategory/delete")
	public String deleteCategory(@RequestParam("categoryId") Integer categoryId, Model model) {
        
		Integer size = productService.getProductsByCategory(categoryId).size();
	
		//model.addAttribute("size", size);
		
		if(size==0) {
			
		categoryService.deleteCategoryByCategoryId(categoryId);
		return "redirect:/user/admin";
	   }		
	   return "redirect:/user/admin/deleteCategory";
	}

}

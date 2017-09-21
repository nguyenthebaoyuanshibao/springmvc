package springmvc_example.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import springmvc_example.service.ProductService;

@Controller
@RequestMapping("")
public class ProductController{
	
	@Autowired 
	private ProductService productService;
	
	//Product Detail Page.
	@RequestMapping("product/detail")
	public ModelAndView getProductId(@RequestParam("id") Integer productId) throws Exception {

		ModelAndView model = new ModelAndView();
		model.addObject("product", this.productService.getProductByProductId(productId));
		model.setViewName("product/product_details");
		
		return model;
	}
	
	// Add Product Page.
	@RequestMapping("/user/admin/addProduct")
    public ModelAndView addProductForm() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("product/add_product");
		
		return model;
	}
	
	//Add Product Result Page.
	@RequestMapping(value ="/user/admin/addProduct/add")
	public ModelAndView addProduct(@RequestParam("id") String url,
			@RequestParam("categoryId") String categoryId, @RequestParam("productName") String productName,
			@RequestParam("unitPrice") Integer unitPrice, @RequestParam("unitsInStock") Integer unitsInStock,
			@RequestParam("description") String description ,@RequestParam("manufacturer") String manufacturer) {
		
		ModelAndView model = new ModelAndView();
		productService.addProduct(url, categoryId, productName, unitPrice, unitsInStock, description, manufacturer);
		model.addObject("msg", "Add Product Success!");
		model.setViewName("product/add_product");
		
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
			@RequestParam("description") String description ,@RequestParam("manufacturer") String manufacturer ) {
		
		ModelAndView model = new ModelAndView();
		productService.updateProduct(productId, url, categoryId, productName, unitPrice, unitsInStock, description, manufacturer);
		model.addObject("msg", "Update Product Success!");
		model.setViewName("product/update_product");
		
		return model;
	}
	
}

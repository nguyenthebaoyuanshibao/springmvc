package springmvc_example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import springmvc_example.service.ProductService;



/**
 * @author life
 *
 */
@Controller
@RequestMapping("")
public class ProductController
{
	
	@Autowired 
	private ProductService productService;
	

//	@RequestMapping
//	public ModelAndView list()
//	{
//		ModelAndView model = new ModelAndView();
//		model.addObject("products", this.productService.getAllProducts());
//		model.setViewName("product/products");
//		return model;
//	}
	

//	@RequestMapping("/all")
//	public ModelAndView allProducts()
//	{
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("products", this.productService.getAllProducts());
//		modelAndView.setViewName("product/products");
//		
//		return modelAndView;
//	}
	
//
//	@RequestMapping("/{categoryId}")
//	public ModelAndView getProductsByCategory(ModelAndView model, @PathVariable(value="categoryId") String categoryId)
//	{   
//		model.addObject("products", this.productService.getProductsByCategory(categoryId));
//		model.setViewName("product/products");
//		return model;
//	}
	
	@RequestMapping("product/detail")
	public ModelAndView getProductId(@RequestParam("id") String productId) throws Exception
	
	{  
	   ModelAndView model = new ModelAndView();
		model.addObject("product", this.productService.getProductById(productId));
		model.setViewName("product/product_details");
		return model;
	}
	
	@RequestMapping("/user/admin/addProduct")
    public ModelAndView addProductForm() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("product/add_product");
		return model;
	}
	
	@RequestMapping("/user/admin/addProduct/add")
	public ModelAndView addProduct(@RequestParam("id") String productId, @RequestParam("url") String url,
			@RequestParam("categoryId") String categoryId, @RequestParam("productName") String productName,
			@RequestParam("unitPrice") Integer unitPrice, @RequestParam("unitsInStock") Integer unitsInStock) {
		
		ModelAndView model = new ModelAndView();
		this.productService.addProduct(productId, url, categoryId, productName, unitPrice, unitsInStock);
		model.addObject("msg", "Add Product Success!");
		model.setViewName("product/add_product");
		return model;
	}
	
	
	
	
}

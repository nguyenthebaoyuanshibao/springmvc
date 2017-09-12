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
@RequestMapping("/products")
public class ProductController
{
	
	@Autowired 
	private ProductService productService;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping
	public ModelAndView list()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("products", this.productService.getAllProducts());
		model.setViewName("product/products");
		return model;
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/all")
	public ModelAndView allProducts()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products", this.productService.getAllProducts());
		modelAndView.setViewName("product/products");
		
		return modelAndView;
	}
	
	/**
	 * @return
	 */
	
	
	/**
	 * @param model
	 * @param argCategory
	 * @return
	 */
	@RequestMapping("/{categoryId}")
	public ModelAndView getProductsByCategory(ModelAndView model, @PathVariable(value="categoryId") String categoryId)
	{   
		model.addObject("products", this.productService.getProductsByCategory(categoryId));
		model.setViewName("product/products");
		return model;
	}
	
	@RequestMapping("/product")
	public ModelAndView getProductByName(@RequestParam("id") String productName) throws Exception
	
	{  
	   ModelAndView model = new ModelAndView();
		model.addObject("products", this.productService.getProductByName(productName));
		model.setViewName("product/product");
		return model;
	}
	
	
	
	
}

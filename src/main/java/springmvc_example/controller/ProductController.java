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
	
}

package springmvc_example.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
import springmvc_example.service.UserService;

@Controller
@RequestMapping("")
public class ProductController{
	
	@Autowired 
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	//Product Detail Page.
	@RequestMapping("product/detail")
	public ModelAndView getProductId(@RequestParam("id") Integer productId) throws Exception {
		ModelAndView model = new ModelAndView();
		String auth = SecurityContextHolder.getContext().getAuthentication().getName();
		Integer userId = userService.findUserbyUserName(auth).getUserId();
		
		model.addObject("userId", userId);
		model.addObject("product", this.productService.getProductByProductId(productId));
		model.setViewName("product/product_details");
		
		return model;
	}
	
}

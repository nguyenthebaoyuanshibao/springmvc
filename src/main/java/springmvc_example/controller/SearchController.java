package springmvc_example.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.dao.ProductDao;
import springmvc_example.dao.ProductDaoImpl;
import springmvc_example.model.Product;
import springmvc_example.service.ProductService;

@Controller
public class SearchController {
	@Autowired
	private ProductService productService;
	
	
	

	@RequestMapping(value = "/products/search/{categoryId}/{priceFrom}/{priceTo}", method = RequestMethod.GET)
	public ModelAndView search(@PathVariable("categoryId") String categoryId,@PathVariable("priceFrom") Integer priceFrom,
			@PathVariable("priceTo") Integer priceTo,@RequestParam("id") String productName ) {
		
	
	   
		ModelAndView model = new ModelAndView();
		
		model.addObject("products",this.productService.search(categoryId, priceFrom, priceTo, productName));
		model.setViewName("product/search");
		return model;

		
	}
}

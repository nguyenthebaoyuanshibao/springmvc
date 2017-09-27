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
import springmvc_example.service.CategoryService;
import springmvc_example.service.ProductService;

@Controller
public class SearchController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	// (Search Product By Many Params) ->Result Page.
	@RequestMapping(value = "/products/search/", method = RequestMethod.GET)
	public ModelAndView getProductBy(@RequestParam("id") String productName,
			@RequestParam("price-from") Integer priceFrom, @RequestParam("price-to") Integer priceTo,
			@RequestParam("category") String categoryId) {

		ModelAndView model = new ModelAndView();

		model.addObject("products", this.productService.getProductBy(categoryId, productName, priceFrom, priceTo));
		model.setViewName("home/home");
		model.addObject("listCategory",categoryService.listCategory() );
		
		return model;
	}
}

package springmvc_example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	ProductDaoImpl productDaoImpl;
	
	@RequestMapping(value= "/products/search", method=RequestMethod.GET)
	public ModelAndView searchProductById(@RequestParam("id") String productId) {
        
		ModelAndView model = new ModelAndView();
		
		Product p = productDaoImpl.getProductById(productId);
		
		if(p.getProductId()!=null) {
			
			model.addObject("product", this.productService.getProductById(productId));

			model.setViewName("product/search_success");

		}
		else {

		
		model.setViewName("product/search_error");
		
		}
		return model;
	}
}

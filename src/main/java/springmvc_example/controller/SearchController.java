package springmvc_example.controller;


import java.util.ArrayList;
import java.util.List;

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
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
	

	@RequestMapping(value = "/products/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam("id") Object object) {
		
		
		String id = String.valueOf(object);
		List<Product> list1 = this.productService.getProductsByCategory(id);
		List<Product> list2 = this.productService.getProductByName(id);
//		List<Product> list3 = new ArrayList<Product>();
//	    if (isInteger(id)) {
//	    	list3 = this.productService.getProductsByPrice(Integer.parseInt(id));
//	    }
	   
	    
		ModelAndView model = new ModelAndView();
		
		model.addObject("products", list1.size()>list2.size()?list1:list2);
		model.setViewName("product/search");
		return model;

		
	}
}

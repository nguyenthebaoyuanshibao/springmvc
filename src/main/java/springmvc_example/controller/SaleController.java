package springmvc_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.service.ProductService;

@Controller
public class SaleController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/order")
	public ModelAndView order() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("product/order");
		return model;
	}

}

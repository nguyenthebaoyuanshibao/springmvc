package springmvc_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.service.ProductService;
import springmvc_example.service.SaleService;

@Controller
public class SaleController {
	@Autowired
	SaleService saleService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/order/{productId}")
	public ModelAndView orderView(@PathVariable("productId") String productId) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("product", productService.getProductById(productId));
		model.setViewName("product/order");
		return model;
	}
	
	@RequestMapping(value="/order/{productId}/{quantity}")
	public ModelAndView orderResult(@PathVariable("productId") String productId, 
			@PathVariable("quantity") Integer quantity){
		String saleId = "12";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userId = auth.getName();
		Integer price = quantity*productService.getProductById(productId).getUnitPrice();
		
		
		ModelAndView model = new ModelAndView();
		saleService.addSale(saleId, userId, productId, price);
		model.setViewName("product/order_result");
		return model;
	}

}

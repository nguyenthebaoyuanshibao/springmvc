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

	// order Page.
	@RequestMapping(value = "/order/{productId}")
	public ModelAndView orderView(@PathVariable("productId") Integer productId) {

		ModelAndView model = new ModelAndView();
		model.addObject("product", productService.getProductByProductId(productId));
		model.setViewName("product/order");
		return model;
	}

	// order Result Page.
	@RequestMapping(value = "/order/{productId}/{quantity}")
	public ModelAndView orderResult(@PathVariable("productId") Integer productId,
			@PathVariable("quantity") Integer quantity) {

		String userId = SecurityContextHolder.getContext().getAuthentication().getName();
		ModelAndView model = new ModelAndView();

		saleService.addSale(userId, productId, quantity,
				quantity * (productService.getProductByProductId(productId).getUnitPrice()));
		model.addObject("product", productService.getProductByProductId(productId));
		model.setViewName("product/product_details");

		return model;
	}

}

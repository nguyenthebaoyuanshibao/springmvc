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

import springmvc_example.service.OrderService;
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
	private OrderService orderService;
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
	@RequestMapping("/order/{productId}/{quantity}")
	public String process(@PathVariable(value="productId") String argProductId, 
						  @PathVariable(value="quantity") Integer argQuantity)
	{
		this.orderService.processOrder(argProductId, argQuantity);
		return "redirect:/products";
	}
	
	/**
	 * @param model
	 * @param argCategory
	 * @return
	 */
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable(value="category") String argCategory)
	{
		model.addAttribute("products", this.productService.getProductsByCategory(argCategory));
		return "products";
	}
	
	/**
	 * @param argFilterParams
	 * @param argModel
	 * @return
	 */
	@RequestMapping("/filter/{byCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar="byCriteria") Map<String, List<String>> argFilterParams, Model argModel)
	{
		argModel.addAttribute("products", this.productService.getProductsByFilter(argFilterParams));
		return "products";
	}
	
	/**
	 * @param argProductId
	 * @param argModel
	 * @return
	 */
	@RequestMapping("/product")
	public ModelAndView getProductById(@RequestParam("id") String argProductId)
	{  
	   ModelAndView model = new ModelAndView();
		model.addObject("product", this.productService.getProductById(argProductId));
		model.setViewName("product/product");
		return model;
	}
	
}

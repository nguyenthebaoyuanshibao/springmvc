package springmvc_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.service.OrderService;



@Controller
public class OrderController
{
	@Autowired
	private OrderService orderService;

	@RequestMapping("/order/P1234/2")
	public String process()
	{
		this.orderService.processOrder("P1234", 2);
		return "redirect:/products";
	}
	@RequestMapping("/order")
	public ModelAndView excute() {
		ModelAndView model = new ModelAndView();
		model.setViewName("product/order");
		return model;
	}
}

package springmvc_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.service.CustomerService;



/**
 * @author life
 *
 */
@Controller
public class CustomerController
{
	@Autowired 
	private CustomerService customerService;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/customers")
	public ModelAndView customerList()
	
	{   ModelAndView model = new ModelAndView();
		model.addObject("customers", this.customerService.getAllCustomers());
		model.setViewName("product/customers");
		return model;
	}

}

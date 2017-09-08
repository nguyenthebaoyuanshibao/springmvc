package springmvc_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springmvc_example.form.UserForm;
import springmvc_example.model.Users;
import springmvc_example.service.UserService;
import springmvc_example.validator.SignupValidator;

@Controller
@RequestMapping("/user")
public class UserController {
   
	@Autowired
	SignupValidator signupValidator;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("user/list");
		model.addObject("list", userService.getListUser() );
		
		return model;
	}
	
	@RequestMapping(value="/changePass/{userId}", method=RequestMethod.GET)
	public ModelAndView changePass(@PathVariable("userId") String userId) {
		ModelAndView model = new ModelAndView("user/change_pass");
		model.addObject("user", userService.findUserbyUserId(userId));
				
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("user") Users user) {
		ModelAndView model = new ModelAndView("user/change_pass");
		userService.updateUser(user.getUserId(), user.getPassword());
		model.addObject("msg", "Password change successful!");
	   return model;
		
		
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET )
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView("user/signup");
		model.addObject("userForm", new UserForm());
		
		return model;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute("userForm") UserForm userForm, BindingResult result, RedirectAttributes redirectAttributes) {
		
		signupValidator.validate(userForm, result);
		
		if(result.hasErrors()) {
			return "/user/signup";
		}
		
		else {
			userService.addUser(userForm.getUserId(), userForm.getPassword());
			redirectAttributes.addFlashAttribute("msg", "Your account has been created successfully!");
			
			return "redirect:/login";
		}
		
		
	}
	@RequestMapping(value="/removeUser/{userId}", method=RequestMethod.GET)
	public ModelAndView removeUser(@PathVariable("userId") String userId) {
		ModelAndView model = new ModelAndView("user/removeUser");
		model.addObject("user", userService.findUserbyUserId(userId));
				
		return model;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute("user") Users user) {
		ModelAndView model = new ModelAndView("user/removeUser");
		userService.deleteUser(user.getUserId());
		model.addObject("msg", "User removed successful!");
	   return model;
	}	
}

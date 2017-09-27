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
import springmvc_example.service.ProductService;
import springmvc_example.service.UserService;
import springmvc_example.validator.SignUpValidator;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	SignUpValidator signupValidator;

	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	// Signup Page.
		@RequestMapping(value = "/signup", method = RequestMethod.GET)
		public ModelAndView signup() {

			ModelAndView model = new ModelAndView("user/signup");
			model.addObject("userForm", new UserForm());

			return model;
		}

		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public String register(@ModelAttribute("userForm") UserForm userForm, BindingResult result,
				RedirectAttributes redirectAttributes) {

			signupValidator.validate(userForm, result);

			if (result.hasErrors()) {
				return "/user/signup";
			} else {
				userService.addUser(userForm.getUserId(), userForm.getPassword());
				redirectAttributes.addFlashAttribute("msg", "Your account has been created successfully!");

				return "redirect:/login";
			}

		}
}

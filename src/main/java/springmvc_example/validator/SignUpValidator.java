package springmvc_example.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import springmvc_example.form.UserForm;
import springmvc_example.service.UserService;
@Component
public class SignUpValidator implements Validator {
	
	@Autowired
	UserService userService;

	public boolean supports(Class<?> clazz) {
		return UserForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {

		UserForm user = (UserForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "notEmpty.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "notEmpty.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "notEmpty.confirmPassword");
		
		if (((user.getPassword() != null) && (user.getPassword() != null)) && (!user.getPassword().equals(user.getConfirmPassword()))) {
			errors.rejectValue("password", "notMatch.confirmPassword");
		}
		
		if (userService.userExists(user.getUserName())) {
			errors.rejectValue("userName", "exists.userName");
		}
	}

}
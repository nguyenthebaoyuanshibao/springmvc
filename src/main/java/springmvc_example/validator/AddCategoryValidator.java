package springmvc_example.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import springmvc_example.form.CategoryForm;
import springmvc_example.service.CategoryService;

@Component
public class AddCategoryValidator {
	
	@Autowired
	CategoryService categoryService;

	public boolean supports(Class<?> clazz) {
		return CategoryForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {

		CategoryForm category = (CategoryForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryName", "notEmpty.categoryName");
		
		
		
		if (categoryService.existsCategory(category.getCategoryName())) {
			errors.rejectValue("categoryName", "exists.categoryName");
		}
	}

}



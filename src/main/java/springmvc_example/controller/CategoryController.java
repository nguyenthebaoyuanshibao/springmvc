package springmvc_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// Delete Category Page.
	@RequestMapping("/user/admin/deleteCategory")
	public ModelAndView deleteCategoryForm() {

		ModelAndView model = new ModelAndView();
		model.setViewName("category/delete_category");

		return model;
	}

	// Delete Category Success Page.
	@RequestMapping("/user/admin/deleteCategory/delete")
	public ModelAndView deleteCategory(@RequestParam("id") String categoryId) {

		ModelAndView model = new ModelAndView();
		categoryService.deleteCategory(categoryId);
		model.addObject("msg", "Delete Category success!");
		model.setViewName("category/delete_category");

		return model;

	}

}

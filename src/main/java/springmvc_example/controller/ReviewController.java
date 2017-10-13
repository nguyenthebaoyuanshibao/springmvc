package springmvc_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.service.ProductService;
import springmvc_example.service.ReviewService;

@Controller
@RequestMapping("")
public class ReviewController {
	
//
//    @Autowired 
//	private ProductService productService;
//	@Autowired
//	private ReviewService reviewService;
//	
//	@RequestMapping("product/detail")
//	public ModelAndView addReview(@RequestParam("id") Integer productId, String reviewInfo){
//
//		ModelAndView model = new ModelAndView();	
//		return model;
//	}

}

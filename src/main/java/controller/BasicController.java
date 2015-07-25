package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicController {

	@RequestMapping("/")
	public ModelAndView getProposls() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	
}

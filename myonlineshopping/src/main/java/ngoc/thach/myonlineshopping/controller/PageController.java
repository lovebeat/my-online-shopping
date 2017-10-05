package ngoc.thach.myonlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping(value= {"/","/index","/home"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","welcome to web mvc" );
		return mv;
	}
//	@RequestMapping(value="/test")
//	public ModelAndView test(@RequestParam(value="greeting", required=false) String greetingVal) {
//		if (greetingVal==null) {
//			greetingVal="Hello from null";
//		}
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting",greetingVal);
//		return mv;
//	}
	@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greetingVal) {
		if (greetingVal==null) {
			greetingVal="Hello from null";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greetingVal);
		return mv;
	}
	
	
	
	
}

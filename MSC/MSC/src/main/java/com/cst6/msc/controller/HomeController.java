package com.cst6.msc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This is default page!");
	  model.setViewName("home");
	  return model;

	}

	@RequestMapping(value = "/admin/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This page is for ROLE_ADMIN only!");
	  model.setViewName("admin/admin");
	  return model;

	}*/
	
	/**
	 * Landing Page
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String land(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		String titleName = "MSC: Global Container Shipping Company";
	    
		model.addAttribute("title", titleName);
		model.addAttribute("serverTime", formattedDate );
		
		return "landing";
	}
	
	/**
	 * Home Page
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/lka", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		String titleName = "Global Container Shipping Company";
	    
		model.addAttribute("title", titleName);
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	
}

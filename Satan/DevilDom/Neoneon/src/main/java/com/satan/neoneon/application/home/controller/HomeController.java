package com.satan.neoneon.application.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String main() {
		return "/home/index";
	}
	
	@RequestMapping(value = "/home1", method = RequestMethod.GET)
	public String main1() {
		return "/home/index1";
	}
}

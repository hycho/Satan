package com.satan.orthanc.application.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		System.out.println("Change Tes111t");
		return "/home/main";
	}
}

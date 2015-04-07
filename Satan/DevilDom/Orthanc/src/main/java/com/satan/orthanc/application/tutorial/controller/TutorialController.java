package com.satan.orthanc.application.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/tutorial")
public class TutorialController {
	@RequestMapping(value = "/tutorial01", method = RequestMethod.GET)
	public String main() {
		return "/tutorial/tutorial01";
	}
}

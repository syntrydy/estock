package com.gasmyr.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	

	@RequestMapping("/")
	public String login(Model model) {
		return "login";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		return "home";
	}

	@RequestMapping("/test")
	public String test(Model model) {
		return "master_layout";
	}
	
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		return "dashboard";
	}	
}

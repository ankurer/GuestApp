package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Welcome")

public class WelcomeCtl {

@RequestMapping(method=RequestMethod.GET)	
public String display(ModelMap model) {
	System.out.println("inside display of welcome");
    
	model.addAttribute("message", "sacfaaaakkkkkkkk");
	
	return "Welcome";
}


}

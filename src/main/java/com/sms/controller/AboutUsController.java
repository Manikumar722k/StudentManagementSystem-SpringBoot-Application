package com.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

	@GetMapping("/aboutUs")
	public String aboutUs()
	{
		return "aboutUs_view";
	}
	@GetMapping("/aboutus")
	public String aboutus()
	{
		return "about_us";
	}
}

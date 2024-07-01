package com.example.jspdemo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JspController {

	@GetMapping("/test")
	@ResponseBody
	public String home() {
		return "hello world of jsp to test download";
	}
	@GetMapping("/testjsp")
		public String homejsp() {
		
		return "mytest";
	}
}

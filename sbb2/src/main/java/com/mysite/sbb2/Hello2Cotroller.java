package com.mysite.sbb2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello2Cotroller {

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		
		return "Hello2 - 수정수정- 수정수정수정";
	}
	
}

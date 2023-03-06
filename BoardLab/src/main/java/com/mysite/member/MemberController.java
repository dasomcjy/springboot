package com.mysite.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@GetMapping("/join")
	public String list() {
		
		return "join";
	}
	
}

package com.mysite.sbb2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UsersController {

	
	private final UsersRepository usersrepository;
	
	@GetMapping("/users/list")
	@PostMapping("/users/list")
	//@ResponseBody
	public String list(Model model) {
		
		List<Users> usersList = this.usersrepository.findAll();
		
		model.addAttribute("usersList", usersList);
		
		Users u = usersList.get(1); 
		System.out.println(u.getName());
		System.out.println(u.getEmail());
		
		
		
		return "users_list";
	}
	
}

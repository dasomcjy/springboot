package com.mysite.sbb2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UsersController {

	
	private final UsersService usersService;
	
	@GetMapping("/users/list")
	public String list(Model model) {
		
		List<Users> usersList = 
				//this.usersrepository.findAll();
				this.usersService.getList();
		
		model.addAttribute("usersList", usersList);
				
		return "users_list";
	}
	
	
	@GetMapping("/users_detail/{id}")
	public String detail(Model model, @PathVariable("t") Integer t) {
		model.addAttribute("user_de", this.usersService.getUsers(t));
		return "users_detail";
	}
	
	@GetMapping("/user_insert")
	public String userInsert() {
				return "users_insert";	
	}
	
	@PostMapping("/insert_info")
	public String insertInfo(@RequestParam String name,@RequestParam String pass,@RequestParam String email) {
		
		this.usersService.insertUsers(name, email, pass);
		return "redirect:/users_list";
	
	}
	
}

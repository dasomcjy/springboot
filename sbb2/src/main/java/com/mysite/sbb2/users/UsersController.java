package com.mysite.sbb2.users;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UsersController {
	
	//DI
	private final UsersService usersService;
	
	
	
//	@GetMapping("users/list") 
	//@ResponseBody
//	public String list(Model model) {
		
//		List<Users> usersList =
				//this.usersRepository.findAll();
//				this.usersService.getList();
		
//		model.addAttribute("usersList", usersList);
		
//		return "users_list";
//	}
	
	
	@GetMapping(value="users/detail/{idx}")
	public String detail(Model model, @PathVariable("idx") Integer idx) {
		
		Users u =
				this.usersService.getUsers(idx);
		
		model.addAttribute("users", u);
		
		return "users_detail";
	}
	
	@GetMapping("/users/insert")
	public String usersInsert(UsersInsert usersInsert) {
		
		return "users_insert";
	}
	
	@PostMapping("/users/insert")
	public String usersInsert(
			//@RequestParam String name, @RequestParam String pass, @RequestParam String email
			@Valid UsersInsert usersInsert , BindingResult bindingResult
			) {
		
				if (bindingResult.hasErrors()) {
					 return "users_insert";
				}
		
		this.usersService.insert(usersInsert.getName(), usersInsert.getPass(),usersInsert.getEmail());
		
		return "redirect:/users/list";
		
	}
	
	@GetMapping("/users/list")
	public String list(Model model, @RequestParam (value="page", defaultValue="0") int page ) {
		
		// 비즈니스로직 처리 : 
		Page<Users> paging = 
			this.usersService.getList(page);
		
		// model 객체에 결과로 받은 paging 객체를 client로 전송
		model.addAttribute("paging", paging);
		
		return "users_list";
				
}
}

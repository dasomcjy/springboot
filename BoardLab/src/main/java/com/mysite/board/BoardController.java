package com.mysite.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;



public class BoardController {


	private final BoardService boardService = null;
	
	
	@GetMapping("/board")
	public String list(Model model) {
		
		List<Board> boardList = this.boardService.getList();
		
		model.addAttribute("boardList", boardList);
		
		return "board";
		
	}
	
	
	@GetMapping(value = "/board/detail/{id}")
	public String detail(Model model, @PathVariable("id") Long id) {
		
		return "board";
	}

	}

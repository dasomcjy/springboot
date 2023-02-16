package com.mysite.sbb.answer;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	
	private final QuestionService questionService;
	private final AnswerService answerService; 
	private final UserService userService;
	
	//http://localhost:9292/answer/create/1 요청에 대한 답변글 등록 처리 
	
	//SeurityConfig.java 에서 @EnableMethodSecurity(prePostEnabled = true) 클래스 위에
	//부여되어 있을때 작동됨
	@PreAuthorize("isAuthenticated()")		//로그인시에만 접근
	@PostMapping("/create/{id}")
	public String createAnswer(
			// << Validation 전 구성 >> 
			//Model model, @PathVariable("id") Integer id,@RequestParam String content
			
			//content의 유효성 검사 
			Model model, @PathVariable("id") Integer id,
			@Valid AnswerForm answerForm, BindingResult bindingResult,
			Principal principal) {
	
		
		Question question = this.questionService.getQuestion(id); 
		
		SiteUser siteUser = this.userService.getUser(principal.getName());
		
		//content 의 값이 비어 있을때 
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("question", question);
			
			return "question_detail";
		}
		
		
		//답변 내용을 저장하는 메소드 호출 (Service에서 호출) 
		
		
		this.answerService.create(question, answerForm.getContent(), siteUser); 
		
		
		return String.format("redirect:/question/detail/%s", id); 
	}
	
	
	 @PreAuthorize("isAuthenticated()")
	 @GetMapping("/modify/{id}")
	 public String answerModify(AnswerForm answerForm, @PathVariable("id") Integer id, Principal principal) {
	
	 Answer answer = this.answerService.getAnswer(id);
	 
	 if (!answer.getAuthor().getUsername().equals(principal.getName())) {
	 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
	 }
	 answerForm.setContent(answer.getContent());
	 return "answer_form";
	 }
		
	 
	 @PreAuthorize("isAuthenticated()")
	 @PostMapping("/modify/{id}")
	 public String answerModify(@Valid AnswerForm answerForm, BindingResult bindingResult,
	 @PathVariable("id") Integer id, Principal principal) {
	 if (bindingResult.hasErrors()) {
	 return "answer_form";
	 }
	 Answer answer = this.answerService.getAnswer(id);
	 if (!answer.getAuthor().getUsername().equals(principal.getName())) {
	 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
	 }
	 this.answerService.modify(answer, answerForm.getContent());
	 return String.format("redirect:/question/detail/%s", answer.getQuestion().getId
	());
	 }
	 
	 @PreAuthorize("isAuthenticated()")
	 @GetMapping("/delete/{id}")
	 public String answerDelete(Principal principal, @PathVariable("id") Integer id) {
	 Answer answer = this.answerService.getAnswer(id);
	 if (!answer.getAuthor().getUsername().equals(principal.getName())) {
	 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
	 }
	 this.answerService.delete(answer);
	 return String.format("redirect:/question/detail/%s", answer.getQuestion().getId
	());
	 }

	}
	


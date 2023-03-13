package com.mysite.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
	
	
	@NotEmpty(message=" 내용이 비어있습니다. 반드시 입력하세요. ")
	private String content;

}

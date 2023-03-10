package com.mysite.sbb2.users;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsersInsert {


		
		@NotEmpty (message="이름은 필수 사항입니다.")  					
		private String name;
		
		
		@NotEmpty (message="비밀번호은 필수 항목입니다.")
		private String pass;
		
		@NotEmpty (message="이메일은 필수 항목입니다.")
		private String email;
		
	}



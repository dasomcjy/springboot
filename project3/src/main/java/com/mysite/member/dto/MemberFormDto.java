package com.mysite.member.dto;

import groovy.transform.builder.Builder;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {
	
	private Integer id;
	
	@NotBlank(message="ID를 입력 하세요.")
	private String mName;
	
	@NotBlank(message="비밀번호를 입력 하세요.")
	private String mPassword;
	
	private String mPasswordConf;
	@NotBlank(message="이메일을 입력 하세요.")
	private String email;
	
	private String addr;

	
    @Builder
	public MemberFormDto(Integer id , String mName , String mPassword , String mPasswordConf, String email ,String addr) {

	this.id = id;
	this.mName = mName;
	this.mPassword = mPassword;
	this.mPasswordConf = mPasswordConf;
	this.email = email;
	this.addr = addr;
			

    }
}

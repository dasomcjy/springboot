package com.mysite.sbb2.users;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@Entity
public class Users {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idx;
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 100)
	private String pass;
	
	@Column(length = 200)
	private String email;
	
	private LocalDateTime regdate;
	
	private Integer cnt;
}

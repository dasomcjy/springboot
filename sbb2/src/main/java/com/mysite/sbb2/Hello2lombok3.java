package com.mysite.sbb2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Hello2lombok3 {

	private String hello2;
	private final int lombok;
	
	public static void main(String[] args) {
		Hello2lombok3 lombok3 = new Hello2lombok3(5);
		
		System.out.println(lombok3);

	}

}

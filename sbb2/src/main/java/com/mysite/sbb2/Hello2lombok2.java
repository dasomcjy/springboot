package com.mysite.sbb2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Hello2lombok2 {

	
	private String hello2;
	private int lombok;
	
	
	public static void main(String[] args) {
		
		Hello2lombok2 lombok2 = new Hello2lombok2("ㅎㅎ" , 55);
	
		
		System.out.println(lombok2.getHello2());
		System.out.println(lombok2.getLombok());
		
		System.out.println(lombok2);
		

	}

}

package com.mysite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.board.Board;
import com.mysite.board.BoardRepository;

@SpringBootTest
class BoardLabApplicationTests {
	
//	@Autowired
//	private MemberRepository memberrepository;
	
//	@Test
//	void testJpa() {
//		
//		Member m1 = new Member();
//		
//		m1.setEmail("aaa@aaa.com");
//		m1.setName("user1");
//		m1.setPassword("1234");
//		m1.setAddress("서울");
//		
//		this.memberrepository.save(m1);
//	}

	
	
	
	
//	@Test
//	void testJpa() {
//		List<Member> all = this.memberrepository.findAll();
//		assertEquals(1, all.size());
//		
//		Member m = all.get(0);
//		
//		assertEquals("user1", m.getName());
//	}
					
	
	@Autowired
	private BoardRepository boardrepository;
	
	@Test
	void testJpa() {
		
		Board b1 = new Board();
		
		b1.setSubject("안녕2");
		b1.setContent("내용3");
		
		
		this.boardrepository.save(b1);
}
}



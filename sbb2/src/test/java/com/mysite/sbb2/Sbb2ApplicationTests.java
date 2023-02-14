package com.mysite.sbb2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb2.users.UsersRepository;




@SpringBootTest
class Sbb2ApplicationTests {


	
	@Autowired
	private UsersRepository usersRepository;
	
	/*
	@Test 
	public void insert1000() {
		Users q = null; 
		
		//for 문을 사용해서 레코드 1000 개 insert 
		for ( int i = 1 ; i <= 1000; i++) {
			q = new Users();
			q.setName("이름 - " + i);
			q.setPass("pass1");
			q.setEmail("메일주소 - " + i);
			q.setRegdate(LocalDateTime.now());
			q.setCnt(i);
			
			this.usersRepository.save(q); 	
		}		
	}
	
	*/
	
	/*
	@Test
	public void testjpa5() {
		// 1. 수정할 객체를 findById() 메소드를 사용해서 가지고 온다.
		Optional<Users> op = 
				this.usersRepository.findByIdx(3);
		
		// 2. 가지고온 객체를 끄집어내서 setter를 사용해서 수정
		Users q = op.get();
		q.setName("수정된 이름");
		q.setEmail("수정된 이메일");
		
		// 3. 수정된 객체를 save(q) 
		this.usersRepository.save(q);
		
	}
	
}
*/
	/*
	@Test
	public void testjpa6 () {
		
		//1. 테이블에서 삭제할 레코드를 가지고 옴
		Optional<Users> op =
				this.usersRepository.findByIdx(4); 

		
		//2. Optional에 저장된 객체를 끄집어낸다.
		Users q = op.get() ;
		
		//3. delete(q)
		this.usersRepository.delete(q);
		
	}
	
	
}

*/
	
	/*


			@Test
			public void test() {
				List<Users> all = 
						this.usersRepository.findAllByOrderByRegdateDesc();
				

				for(int i = 0 ; i < all.size() ; i++) {
					Users u = all.get(i);
					
					System.out.println(u.getIdx());
					System.out.println(u.getName());
					System.out.println(u.getPass());
					System.out.println(u.getEmail());
					System.out.println(u.getRegdate());
				}
			}
	}

	*/
	/*
	@Test
	void contextLoads() {
		Users U2 = new Users();
		U2.setRegdate(LocalDateTime.now()); 
		U2.setName("이름2");
		U2.setPass("pass2");
		U2.setEmail("Email2");
		this.usersRepository.save(U2);		
		
		Users U3 = new Users();
		U3.setRegdate(LocalDateTime.now()); 
		U3.setName("이름3");
		U3.setPass("pass3");
		U3.setEmail("Email3");
		this.usersRepository.save(U3);		
		
		Users U4 = new Users();
		U4.setRegdate(LocalDateTime.now()); 
		U4.setName("이름4");
		U4.setPass("pass4");
		U4.setEmail("Email4");
		this.usersRepository.save(U4);		
		
		Users U5 = new Users();
		U5.setRegdate(LocalDateTime.now()); 
		U5.setName("이름5");
		U5.setPass("pass5");
		U5.setEmail("Email5");
		this.usersRepository.save(U5);		
		
}

*/
}	 	


package com.mysite.sbb2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
	
	private final UsersRepository usersRepository;
	
	public List<Users> getList(){
			return this.usersRepository.findAll();
	}

	
	public Users getUsers(Integer id) {
		Optional<Users> op=
				this.usersRepository.findByIdx(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			throw new DataNotFoundException("요청한 파일을 찾을 수 없습니다.");
		}
	}
	
	public void insertUsers(String name, String email, String pass) {
		
		Users u = new Users();
		
		u.setCnt(null);
		u.setRegdate(LocalDateTime.now());
		u.setName(name);
		u.setEmail(email);
		u.setPass(pass);
		
		this.usersRepository.save(u);
	}
	
}

package com.mysite.sbb2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Integer> {

	//List<Users> findBySubjectLikeOrderByCreateDateDesc(String name);
	
	List<Users> findAllByOrderByRegdateDesc(); 
	List<Users> findAllByOrderByRegdate(); 
	Optional<Users> findByIdx(Integer idx);
	
	
	
}

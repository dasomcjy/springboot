package com.mysite.sbb2.users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsersRepository extends JpaRepository<Users, Integer> {

	//List<Users> findBySubjectLikeOrderByCreateDateDesc(String name);
	
	List<Users> findAllByOrderByRegdateDesc(); 
	Optional<Users> findByIdx(Integer idx);
	
	Page<Users> findAll(Pageable pageable);
	
}

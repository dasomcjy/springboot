package com.mysite.sbb.question;

import java.time.LocalDateTime;		// 자신의 시스템의 로케일의 시간설정 
import java.util.List;
import java.util.Set;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
//persistence : JPA에서 사용된 어노테이션
import jakarta.persistence.Entity;		//JPA 에서 적용된 어노테이션 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity		// 자바클래스를 DataBase의 테이블과 매핑된 클래스 : 테이블명 : question
public class Question {
	
	@Id	// primary key 
	@GeneratedValue (strategy = GenerationType.IDENTITY)    //시퀀스 할당
	private Integer id; //Primary Key , 시퀀스 (1 , 1)
	
	@Column(length = 200)		//200자까지 
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;		//create_date : 이렇게 바뀜 ! 낙타케이스

	
	/*
	@Column(length = 300)
	private String addr ; 
	*/ 

	//Question 테이블에서 Answer 테이블을 참조하는 컬럼을 생성 @OnetoMany
	@OneToMany (mappedBy = "question" , cascade = CascadeType.REMOVE)
	private List<Answer> answerList; 
	
		//question.getAnswerList() ;
	
	@ManyToOne		//Foreign Key : site_user 테이블의 Primary key 참조
	private SiteUser author;
	
	private LocalDateTime modifyDate;
	
	
	 @ManyToMany
	 
	 Set<SiteUser> voter;
	
}

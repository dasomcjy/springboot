package com.mysite.board;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Board {


	    @Id
	    @Column(name="board_id")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @Column(length = 200)
	    private String subject;

	    @Column(length = 4000)
	    private String content;

	    @CreatedDate
	    private LocalDateTime createDate;	
	    
//	    @ManyToOne
//		private Member author;
//		
//		private LocalDateTime modifyDate;

}

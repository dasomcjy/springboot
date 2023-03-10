package com.mysite.info;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

//	@GetMapping("/recommendList")
//	public String getRecommendList(HttpSession session, Model model) {
//	  //session에 저장되어있는 회원 id와 도서관 코드를 getting해서 String타입을 업캐스팅
//	  String memberId = (String) session.getAttribute("SID");
//	  String libraryCode = (String) session.getAttribute("SLIBRARY");
//
//	  //회원 id로 최근 대여한 5건의 도서 isbn을 조회 및 api 호출해서 추천 도서의 isbn을 list형태로 리턴
//	  List<String> bookIsbn = recommendservice.recommendList(memberId);
//	  // List 형태로 객체화
//	  List<Book> book = new ArrayList<Book>();
//
//	  //추천된 isbn 갯수만큼 반복문
//	  for(int i =0 ; i<bookIsbn.size();i++) {
//	    //isbn과 도서관 코드로 해당 도서가 도서관에 보유중인지 조회
//	    List<Book> getBook = bookService.isbnSelectBook(bookIsbn.get(i), libraryCode);
//	    if(getBook != null) {
//	      book.addAll(getBook);
//	    }else{
//	      //getBook이 null 일때 isbn 없이 api 호출(미구현)
//	    }
//	  }
//	  logger.info("book : {}", book);
//	  model.addAttribute("book", book);
//	  return "recommend/recommendList";
//	}
	
}

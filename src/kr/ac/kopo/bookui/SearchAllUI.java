package kr.ac.kopo.bookui;

import java.util.List;

import kr.ac.kopo.BookServiceFactory;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class SearchAllUI extends BaseUI {
	
	private BookService service;
	
	public SearchAllUI() {
		service = BookServiceFactory.getInstance();
	}

	
	@Override
	public void execute() {
		
		List<BookVO> bookList = service.selectAll();
		
		System.out.println("=======================================");
		System.out.println("번호\t제목\t글쓴이\t출판사\t대여가능");
		System.out.println("---------------------------------------");

		if(bookList == null || bookList.size() == 0 ) {
			System.out.println("\t   책이 존재하지 않습니다.");
		} else {
			for(BookVO book : bookList) {
				System.out.println(book.getNo()+"\t"+book.getTitle()+"\t"+book.getWriter()
								+"\t"+book.getPublisher()+"\t  "+book.getCount());
			}
		}
		System.out.println("=======================================");	
		
		
	}
	
	
	
	
	
	
}

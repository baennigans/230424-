package kr.ac.kopo.bookui;

import kr.ac.kopo.BookServiceFactory;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class AddUI extends BaseUI {

	private BookService service;	
	
	public AddUI() {
		service = BookServiceFactory.getInstance();
	}
	
	@Override
	public void execute() throws Exception {
		
		String title = scanStr("등록할 책의 제목을 입력하세요 : ");
		String writer = scanStr("등록할 책의 저자를 입력하세요 : ");
		String publisher = scanStr("등록할 책의 출판사를 입력하세요 : ");
		int count = scanInt("등록할 책의 권 수를 입력하세요 : ");
		
		BookVO book = new BookVO();
		book.setTitle(title);
		book.setWriter(writer);
		book.setPublisher(publisher);
		book.setCount(count);
		
		service.insertBook(book);
		
		System.out.println("=======================================");
		System.out.println("\t   새 책 등록을 완료하였습니다.");
		System.out.println("=======================================");

	}
}

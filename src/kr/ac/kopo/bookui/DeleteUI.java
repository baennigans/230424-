package kr.ac.kopo.bookui;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class DeleteUI extends BaseUI {

	private BookService service;
	
	public DeleteUI() {
		service = new BookService();		
	}
	

	@Override
	public void execute() throws Exception {
		
		int no = scanInt("삭제할 책 번호를 입력하세요 : ");
		
		BookVO book = service.selectByNo(no);
		
		System.out.println("=======================================");
		
		if (book != null) {
			service.deleteBook(book);
			System.out.println("   "+ no +"번 책 ["+ book.getTitle() +"]을 삭제하였습니다.");
		} else {
			System.out.println("   [" + no + "]번 책은 존재하지 않습니다.");			
		}
		
		System.out.println("=======================================");
	}

}

package kr.ac.kopo.bookui;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class SearchOneUI extends BaseUI {

	private BookService service;

	public SearchOneUI() {
		service = new BookService();
	}

	@Override
	public void execute() throws Exception {

		int no = scanInt("검색할 책 번호를 입력하세요 : ");

		BookVO book = service.selectByNo(no);

		System.out.println("=======================================");
		if (book != null) {
			System.out.println("   번     호	 :  " + book.getNo());
			System.out.println("   제     목	 :  " + book.getTitle());
			System.out.println("   글  쓴  이	 :  " + book.getWriter());
			System.out.println("   출  판  사	 :  " + book.getPublisher());
			System.out.println("   대여가능권수	 :  " + book.getCount());
		} else { 
			System.out.println("   [" + no + "]번 책이 존재하지 않습니다");
		}
		System.out.println("=======================================");

	}
}

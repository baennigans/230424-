package kr.ac.kopo.bookui;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.BookVO;
import kr.ac.kopo.vo.MemberVO;

public class ReturnUI extends BaseUI {

	private BookService service;
	private MemberService service2;

	public ReturnUI() {
		service = new BookService();
		service2 = new MemberService();
	}

	@Override
	public void execute() throws Exception {

		String id = scanStr("아이디를 입력하세요 : ");
		int no = scanInt("반납할 책번호를 입력하세요 : ");

		MemberVO member = service2.selectById(id);
		BookVO book = service.selectByNo(no);

		System.out.println("=======================================");
		if (book == null) {
			System.out.println("   [" + no + "]번 책은 존재하지 않습니다.");
		} else {
			service.returnBook(book);
			service.returnBook2(member, book);
			System.out.println("   " + no + "번 책 [" + book.getTitle() + "]을 반납하였습니다.");
		}
		System.out.println("=======================================");

	}

}

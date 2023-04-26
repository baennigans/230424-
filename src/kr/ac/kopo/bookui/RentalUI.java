package kr.ac.kopo.bookui;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.BookVO;
import kr.ac.kopo.vo.MemberVO;

public class RentalUI extends BaseUI {

	
	private BookService service;
	private MemberService service2;
	
	public RentalUI() {
		service = new BookService();
		service2 = new MemberService();
	}

	
	@Override
	public void execute() throws Exception {
		
		member2 = member.logstatic();
		
		if (member == null) {
			System.out.println("=======================================");
			System.out.println("\t   아이디를 잘못 입력하였습니다.");
			System.out.println("=======================================");
			return;
		}
		
		int no = scanInt("대여할 책번호를 입력하세요 : ");
		
		BookVO book = service.selectByNo(no);
		System.out.println("=======================================");
		if (book == null) {
			System.out.println("   [" + no + "]번 책은 존재하지 않습니다.");			
		} else if(book.getCount() == 0) {
			System.out.println("   대여가능한 ["+ no +"]번 책이 없습니다.");
		} else {
			service.rentalBook(book);
			service.rentalBook2(member2, book);
			System.out.println("   "+ no +"번 책 ["+ book.getTitle() +"]을 대여하였습니다.");
		}
		System.out.println("=======================================");			

	}

}

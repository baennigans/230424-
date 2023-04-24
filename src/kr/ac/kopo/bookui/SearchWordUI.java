package kr.ac.kopo.bookui;

import java.util.List;

import kr.ac.kopo.BookServiceFactory;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class SearchWordUI extends BaseUI {
	
	private BookService service;
	
	public SearchWordUI() {
		service = BookServiceFactory.getInstance();
	}

	
	@Override
	public void execute() {
		
		String word = scanStr("검색할 단어를 입력하세요 : ");
		
		List<BookVO> bookList = service.selectByWord(word);
		
		System.out.println("=======================================");
		if(bookList == null || bookList.size() == 0 ) {
			System.out.println("   ["+word+"]가 포함된 책이 존재하지 않습니다.");
		} else {
			System.out.println("번호\t제목\t글쓴이\t출판사\t대여가능");
			System.out.println("---------------------------------------");
			for(BookVO book : bookList) {
				System.out.println(book.getNo()+"\t"+book.getTitle()+"\t"+book.getWriter()
								+"\t"+book.getPublisher()+"\t  "+book.getCount());
			}
		}
		System.out.println("=======================================");	
		
	}
}

package kr.ac.kopo;

import kr.ac.kopo.service.BookService;

public class BookServiceFactory {

	private static BookService service = null;
	
	public static BookService getInstance() {
		
		if(service == null) {
			service = new BookService();
		}
		return service;
	}
}

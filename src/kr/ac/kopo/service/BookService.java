package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BookDAO;
import kr.ac.kopo.vo.BookVO;
import kr.ac.kopo.vo.MemberVO;

public class BookService {

	private BookDAO bookDao;
	
	
	public BookService() {
		bookDao = new BookDAO();
	}
		
	
	public void insertBook(BookVO book) {
		bookDao.insertBook(book);
	}
	
	
	public void deleteBook(BookVO book) {
		bookDao.deleteBook(book);		
	}
	
	
	public void rentalBook(BookVO book) {
		bookDao.rentalBook(book);
	}
	
	
	public void rentalBook2(MemberVO member, BookVO book) {
		bookDao.rentalBook2(member, book);
	}
	
	
	public void returnBook(BookVO book) {
		bookDao.returnBook(book);
	}
	
	
	public void returnBook2(MemberVO member, BookVO book) {
		bookDao.returnBook2(member, book);
	}
	
	
	public List<BookVO> selectAll() {
		List<BookVO> bookList = bookDao.selectAllBook();
		return bookList;
	}
	
	
	public BookVO selectByNo(int bookNo) {
		BookVO book = bookDao.selectBookByNo(bookNo);
		return book;
	}


	public List<BookVO> selectByWord(String bookWord) {
		List<BookVO> bookList = bookDao.selectBookByWord(bookWord);
		return bookList;
	}


}

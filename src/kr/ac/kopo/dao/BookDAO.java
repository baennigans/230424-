package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BookVO;
import kr.ac.kopo.vo.MemberVO;


public class BookDAO {
	
	
	
	
	public List<BookVO> selectAllBook() {
		
		List<BookVO> bookList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, publisher, count ");
		sql.append("from t_book ");
		sql.append("order by no ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				int count = rs.getInt("count");
				
				BookVO book = new BookVO();
				book.setNo(no);
				book.setTitle(title);
				book.setWriter(writer);
				book.setPublisher(publisher);
				book.setCount(count);
				
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	
	
	
	
	public BookVO selectBookByNo(int bookNo) {
		
		BookVO book = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, publisher, count ");
		sql.append("from t_book ");
		sql.append("where no = ? ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			
			pstmt.setInt(1, bookNo);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				int count = rs.getInt("count");
				
				book = new BookVO(no, title, writer, publisher, count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	
	
	
	
	
	public List<BookVO> selectBookByWord(String bookWord) {
		
		List<BookVO> bookList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, publisher, count ");
		sql.append("from t_book ");
		sql.append("where title like ? ");
		sql.append("or writer like ? ");
		sql.append("or publisher like ? ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			
			bookWord = '%'+bookWord+'%';
			
			pstmt.setString(1, bookWord);
			pstmt.setString(2, bookWord);
			pstmt.setString(3, bookWord);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				int count = rs.getInt("count");
				
				BookVO book = new BookVO();
				book.setNo(no);
				book.setTitle(title);
				book.setWriter(writer);
				book.setPublisher(publisher);
				book.setCount(count);
				
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	
	
	
	
	
	public void insertBook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_book(no,title,writer,publisher,count) ");
		sql.append("values(seq_t_book_no.nextval, ? , ? , ? , ? ) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getCount());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	
	
	
	public void deleteBook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_book ");
		sql.append("where no = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setInt(1, book.getNo());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	
	
	public void rentalBook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("update t_book ");
		sql.append("set count = ? ");
		sql.append("where no = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setInt(1, book.getCount()-1);
				pstmt.setInt(2, book.getNo());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	public void rentalBook2(MemberVO member , BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_rental(cnt,id,no,title,writer) ");
		sql.append("values(seq_t_rental_cnt.nextval, ? , ? , ? , ? ) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, member.getId());
			pstmt.setInt(2, book.getNo());
			pstmt.setString(3, book.getTitle());
			pstmt.setString(4, book.getWriter());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	public void returnBook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("update t_book ");
		sql.append("set count = ? ");
		sql.append("where no = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setInt(1, book.getCount()+1);
				pstmt.setInt(2, book.getNo());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	public void returnBook2(MemberVO member, BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_rental ");
		sql.append("where id = ? ");
		sql.append("and title = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, member.getId());
				pstmt.setString(2, book.getTitle());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}

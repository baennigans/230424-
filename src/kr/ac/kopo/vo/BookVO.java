package kr.ac.kopo.vo;

public class BookVO {

	private int no;
	private String title;
	private String writer;
	private String publisher;
	private int count;
	
	
	public BookVO() {
		super();
	}


	public BookVO(int no,String title, String writer, String publisher, int count) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.count = count;
	}


	public int getNo() {
		return no;
	}

	
	public void setNo(int no) {
		this.no = no;
	}
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriter() {
		return writer;
	}
	

	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getCount() {
		return count;
	}

	
	public void setCount(int count) {
		this.count = count;
	}
	
	
	@Override
	public String toString() {
		return "BookVO [no=" + no + ", title=" + title + ", writer=" + writer 
				+ ", publisher=" + publisher + ", count=" + count + "]";
	}
	
}

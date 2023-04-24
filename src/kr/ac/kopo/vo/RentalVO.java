package kr.ac.kopo.vo;

public class RentalVO {

	private String id;
	private int no;
	private String title;
	private String writer;
	
	
	public RentalVO() {
		super();
	}
	
	
	public RentalVO(String id, int no, String title, String writer) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.writer = writer;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "RentalVO [no=" + no + ", id=" + id + ", title=" + title + ", writer=" + writer + "]";
	}
	
}

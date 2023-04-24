package kr.ac.kopo.bookui;

import java.util.List;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.RentalVO;

public class RentalListUI extends BaseUI {

	
	private MemberService service;
	
	public RentalListUI() {
		service = new MemberService();
	}
	
	
	@Override
	public void execute() throws Exception {
		
		List<RentalVO> rentalList = service.rentalAll();

		System.out.println("=======================================");
		System.out.println("아이디\t번호\t책제목\t글쓴이");
		System.out.println("---------------------------------------");

		if(rentalList == null || rentalList.size() == 0 ) {
			System.out.println("\t   대여중인 책이 존재하지 않습니다.");
		} else {
			for(RentalVO rental : rentalList) {
				System.out.println(rental.getId()+"\t"+rental.getNo()+"\t"+rental.getTitle()+"\t"+rental.getWriter());
			}
		}
		System.out.println("=======================================");	
		
	}
}

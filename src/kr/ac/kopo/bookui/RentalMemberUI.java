package kr.ac.kopo.bookui;

import java.util.List;

import kr.ac.kopo.MemberServiceFactory;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.RentalVO;

public class RentalMemberUI extends BaseUI {

	private MemberService service;

	public RentalMemberUI() {
		service = MemberServiceFactory.getInstance();
	}

	@Override
	public void execute() throws Exception {

		String id = scanStr("아이디를 입력하세요 : ");

		MemberVO member = service.selectById(id);
		if (member == null) {
			System.out.println("=======================================");
			System.out.println("\t   아이디를 잘못 입력하였습니다.");
			System.out.println("=======================================");
			return;
		}
		
		List<RentalVO> rentalList = service.rentalMember(member);

		System.out.println("=======================================");
		System.out.println("아이디\t번호\t책제목\t글쓴이");
		System.out.println("---------------------------------------");

		if (rentalList == null || rentalList.size() == 0) {
			System.out.println("\t대여중인 책이 존재하지 않습니다.");
		} else {
			for (RentalVO rental : rentalList) {
				System.out.println(rental.getId()+"\t"+rental.getNo()+"\t"+rental.getTitle()+"\t"+rental.getWriter());
			}
		}
		System.out.println("=======================================");

	}
}

package kr.ac.kopo.memberui;

import java.util.List;

import kr.ac.kopo.MemberServiceFactory;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class SearchAllUI extends BaseUI {

	
	private MemberService service;
	
	
	public SearchAllUI() {
		service = MemberServiceFactory.getInstance();
	}
	
	
	@Override
	public void execute() throws Exception {

		List<MemberVO> memberList = service.selectAll();
		
		System.out.println("=======================================");
		System.out.println("아이디\t비밀번호\t이름\t연락처");
		System.out.println("---------------------------------------");

		if(memberList == null || memberList.size() == 0 ) {
			System.out.println("\t   회원이 존재하지 않습니다.");
		} else {
			for(MemberVO member : memberList) {
				System.out.println(member.getId()+"\t"+member.getPassword()+"\t"
			                          +member.getName()+"\t"+member.getPhone());
			}
		}
		System.out.println("=======================================");	
		
	}
}

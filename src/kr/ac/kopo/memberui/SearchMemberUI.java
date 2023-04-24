package kr.ac.kopo.memberui;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class SearchMemberUI extends BaseUI {

	
	private MemberService service;
	
	public SearchMemberUI() {
		service = new MemberService();
	}
					
			
	@Override
	public void execute() throws Exception {
		
		String memberid = scanStr("아이디를 입력하세요 : ");
		String memberpw = scanStr("비밀번호를 입력하세요 : ");
		
		MemberVO member = service.selectById(memberid);
		
		System.out.println("=======================================");
		if(member == null || !memberpw.equals(member.getPassword())) {
			System.out.println("   아이디 또는 비밀번호를 잘못입력하였습니다.");
		} else {
			System.out.println("   아  이  디	 :  " + member.getId());
			System.out.println("   비 밀 번 호	 :  " + member.getPassword());
			System.out.println("   이     름	 :  " + member.getName());
			System.out.println("   휴  대  폰	 :  " + member.getPhone());
		}
		System.out.println("=======================================");
		
	}
}

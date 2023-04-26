package kr.ac.kopo.memberui;

import kr.ac.kopo.service.MemberService;

public class SearchMyInfoUI extends BaseUI {

	
	private MemberService service;
	
	public SearchMyInfoUI() {
		service = new MemberService();
	}
					
			
	@Override
	public void execute() throws Exception {
		
		String memberpw = scanStr("비밀번호를 입력하세요 : ");
		
		member2 = member.logstatic();
		
		
		System.out.println("=======================================");
		if(!memberpw.equals(member2.getPassword())) {
			System.out.println("   아이디 또는 비밀번호를 잘못입력하였습니다.");
		} else {
			System.out.println("   아  이  디	 :  " + member2.getId());
			System.out.println("   비 밀 번 호	 :  " + member2.getPassword());
			System.out.println("   이     름	 :  " + member2.getName());
			System.out.println("   휴  대  폰	 :  " + member2.getPhone());
		}
		System.out.println("=======================================");
		
	}
}

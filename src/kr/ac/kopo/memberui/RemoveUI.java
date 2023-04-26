package kr.ac.kopo.memberui;

import kr.ac.kopo.LoginStatic;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class RemoveUI extends BaseUI {

	
	private MemberService service;
	
	
	public RemoveUI() {
		service = new MemberService();
	}
	
	@Override
	public void execute() throws Exception {

		String memberpw = scanStr("비밀번호를 입력하세요 : ");
	
		member2 = member.logstatic();

		if(!memberpw.equals(member2.getPassword())) {
			System.out.println("=======================================");
			System.out.println("   아이디 또는 패스워드를 잘못입력하였습니다.");
			System.out.println("=======================================");
		} else {
			String answer = scanStr("정말 탈퇴하시겠습니다? (Y/N) : ");

			System.out.println("=======================================");
			if(answer.equals("Y") || answer.equals("y")) {
				service.removeMember(member2);
				System.out.println("\t   회원탈퇴를 완료하였습니다.");
				System.out.println("=======================================\n\n");
				FirstPageUI ui = new FirstPageUI();
				ui.execute();
			} else {
				System.out.println("\t   탈퇴가 취소되었습니다.");
				System.out.println("=======================================");
			}
			
		}
	}
}

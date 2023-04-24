package kr.ac.kopo.memberui;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class LoginUI extends BaseUI {

	
	private MemberService service;

	
	public LoginUI() {
		service = new MemberService();
	}

	
	@Override
	public void execute() throws Exception {

		int choice = scanInt("1.회원로그인 / 2.관리자로그인 : ");

		String memberid = scanStr("아이디를 입력하세요 : ");
		String memberpw = scanStr("비밀번호를 입력하세요 : ");

		MemberVO member = service.selectById(memberid);

		if (member == null || !memberpw.equals(member.getPassword())) {
			System.out.println("=======================================");
			System.out.println("   아이디 또는 패스워드를 잘못입력하였습니다.");
			System.out.println("=======================================");
		} else {
			if (choice == 2) {
				int pw = scanInt("관리자 비밀번호를 입력하세요 : ");
				if (pw == 2580) {
					System.out.println("\n");
					ManagerUI ui = new ManagerUI();
					ui.execute();
				} else {
					System.out.println("=======================================");
					System.out.println("\t   잘못입력하였습니다.");
					System.out.println("=======================================");
				}
			} else {
				System.out.println("\n");
				MemberUI ui = new MemberUI();
				ui.execute();
			}
		}
	}
}

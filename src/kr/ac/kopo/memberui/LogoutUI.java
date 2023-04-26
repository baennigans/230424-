package kr.ac.kopo.memberui;

import kr.ac.kopo.LoginStatic;

public class LogoutUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		String answer = scanStr("정말 로그아웃 하시겠습니다? (Y/N) : ");
		
		System.out.println("=======================================");
		if(answer.equals("Y") || answer.equals("y")) {
			System.out.println("\t   로그아웃 하였습니다.");	
			System.out.println("=======================================\n\n");
			
			LoginStatic member = new LoginStatic();
			member = null;
			
			FirstPageUI ui = new FirstPageUI();
			ui.execute();
		} else {
			System.out.println("\t   로그아웃이 취소되었습니다.");
			System.out.println("=======================================");
			return;
		}
		
	}
}

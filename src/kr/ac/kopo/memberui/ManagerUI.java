package kr.ac.kopo.memberui;

import kr.ac.kopo.bookui.ManagerBookUI;

public class ManagerUI extends BaseUI {

	
	private int menu() {
		
		System.out.println("***** 회원관리 시스템 *****");
		System.out.println("1. 도서관 이용하기");
		System.out.println("2. 전체 회원 조회");
		System.out.println("3. 회원 정보변경");
		System.out.println("4. 로그아웃");
		System.out.println("5. 회원 탈퇴");
		System.out.println("0. 종료");
		System.out.println("***********************");
		int type = scanInt("원하는 항목을 선택하세요 : ");
		
		return type;
	}
	
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
			
			int type = menu();
			
			IMemberUI ui = null;
			
			System.out.println();
			switch(type) {
			case 1:
				System.out.println("도서관 이용하기를 선택하였습니다.\n");
				ManagerBookUI managerbook = new ManagerBookUI();
				managerbook.execute();
				break;
			case 2:
				System.out.println("전체회원조회를 선택하였습니다.");
				ui = new SearchAllUI();
				break;
			case 3:
				System.out.println("회원정보변경을 선택하였습니다.");
				ui = new UpdateUI();
				break;
			case 4:
				System.out.println("로그아웃을 선택하였습니다.");
				ui = new LogoutUI();
				break;
			case 5:
				System.out.println("회원탈퇴를 선택하였습니다.");
				ui = new RemoveUI();
				break;
			case 0:
				ui = new ExitUI();
				break;
			}
			
			if(ui != null) {
				ui.execute();
			} else {
				System.out.println("=======================================");
				System.out.println("\t   잘못입력하였습니다.");
				System.out.println("=======================================");
			}
			
			System.out.println("\n");
		}
	}
}
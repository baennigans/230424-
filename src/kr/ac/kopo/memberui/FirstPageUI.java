package kr.ac.kopo.memberui;

public class FirstPageUI extends BaseUI {

	private int menu() {

		System.out.println("******* OO 도서관 *******");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("0. 종료");
		System.out.println("***********************");
		int type = scanInt("원하는 항목을 선택하세요 : ");

		return type;
	}

	@Override
	public void execute() throws Exception {

		while (true) {

			int type = menu();

			IMemberUI ui = null;

			System.out.println();
			switch (type) {
			case 1:
				System.out.println("로그인을 선택하였습니다.");
				ui = new LoginUI();
				break;
			case 2:
				System.out.println("회원가입을 선택하였습니다.");
				ui = new AddUI();
				break;
			case 0:
				ui = new ExitUI();
				break;
			}

			if (ui != null) {
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

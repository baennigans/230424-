package kr.ac.kopo.bookui;

public class MemberBookUI extends BaseUI {
	
	
	private int menu() {
		
		System.out.println("****** 내 도서 관리 ******");
		System.out.println("1. 전체 도서 목록 출력");
		System.out.println("2. 도서 검색");
		System.out.println("3. 도서 대여");
		System.out.println("4. 도서 반납");
		System.out.println("5. 나의 대여 목록 검색");
		System.out.println("0. 종료");
		System.out.println("***********************");
		int type = scanInt("원하는 항목을 선택하세요 : ");
		
		return type;
	}
	
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
			
			int type = menu();
			
			IBookUI ui = null;
			
			System.out.println();
			switch(type) {
			case 1:
				System.out.println("전체 도서 목록 출력을 선택하였습니다.");
				ui = new SearchAllUI();
				break;
			case 2:
				System.out.println("도서 검색을 선택하였습니다.");
				int choice = scanInt("1.단어로검색 / 2.책번호로검색 : ");
				if(choice==1) {
					ui = new SearchWordUI();
				} else if (choice==2) {
					ui = new SearchOneUI();					
				} 
				break;
			case 3:
				System.out.println("도서 대여을 선택하였습니다.");
				ui = new RentalUI();
				break;
			case 4:
				System.out.println("도서 반납을 선택하였습니다.");
				ui = new ReturnUI();
				break;
			case 5:
				System.out.println("나의 대여 목록 검색을 선택하였습니다.");
				ui = new RentalMyUI();
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
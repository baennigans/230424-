package kr.ac.kopo.bookui;

public class ExitUI extends ManagerBookUI {

	@Override
	public void execute() throws Exception {
		
		System.out.println("=======================================");
		System.out.println("\t   시스템을 종료합니다.");
		System.out.println("=======================================");
		System.exit(0);

	}
}

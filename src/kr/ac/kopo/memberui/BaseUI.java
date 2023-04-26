package kr.ac.kopo.memberui;

import java.util.Scanner;

import kr.ac.kopo.LoginStatic;
import kr.ac.kopo.vo.MemberVO;

public abstract class BaseUI implements IMemberUI {

	private Scanner sc;
	public LoginStatic member;
	public MemberVO member2;
	
	
	public BaseUI() {
		sc = new Scanner(System.in);
		member = new LoginStatic();
		member2 = new MemberVO();
	}

	
	protected int scanInt(String msg) {
		System.out.print(msg);
		int num = Integer.parseInt(sc.nextLine());
		return num;
	}

	
	protected String scanStr(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}
	
}

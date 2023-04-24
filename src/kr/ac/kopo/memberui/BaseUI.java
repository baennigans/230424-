package kr.ac.kopo.memberui;

import java.util.Scanner;

public abstract class BaseUI implements IMemberUI {

	private Scanner sc;

	public BaseUI() {
		sc = new Scanner(System.in);
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

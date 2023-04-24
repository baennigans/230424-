package kr.ac.kopo;

import kr.ac.kopo.memberui.FirstPageUI;

public class ProjectMain {

	public static void main(String[] args) {
		
		try {
			new FirstPageUI().execute();
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}
}

package kr.ac.kopo;

import kr.ac.kopo.vo.MemberVO;

public class LoginStatic {

	static MemberVO member;
	
	public LoginStatic(MemberVO member) {
		
		this.member = member;
		
	}

	public LoginStatic() {
	}
	
	
	public MemberVO logstatic() {
		return member;
	}
}

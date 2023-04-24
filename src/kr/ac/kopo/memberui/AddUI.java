package kr.ac.kopo.memberui;

import kr.ac.kopo.MemberServiceFactory;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class AddUI extends BaseUI {

	private MemberService service;
	
	public AddUI() {
		service = MemberServiceFactory.getInstance();
	}
	
	@Override
	public void execute() throws Exception {
		
		String id = scanStr("아이디를 입력하세요 : ");
		String password = scanStr("비밀번호를 입력하세요 : ");
		String name = scanStr("이름을 입력하세요 : ");
		String phone = scanStr("휴대폰 번호를 입력하세요 : ");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setPhone(phone);
		
		service.insertMember(member);
	}
}

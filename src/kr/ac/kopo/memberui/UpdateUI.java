package kr.ac.kopo.memberui;

import kr.ac.kopo.service.MemberService;

public class UpdateUI extends BaseUI {

	
	private MemberService service;
	
	
	public UpdateUI() {
		service = new MemberService();
	}
	
	
	@Override
	public void execute() throws Exception {
		
		String memberpw = scanStr("비밀번호를 입력하세요 : ");
		
		member2 = member.logstatic();

		if(!memberpw.equals(member2.getPassword())) {
			System.out.println("=======================================");
			System.out.println("   아이디 또는 비밀번호를 잘못입력하였습니다.");
			System.out.println("=======================================");
		} else {
			int no = scanInt("변경하실 정보를 선택하세요 (1.비밀번호 / 2.이름 / 3.연락처) : ");
			
			switch(no) {
			case 1 :
				String newpw = scanStr("변경할 비밀번호를 입력하세요 : ");
				member2.setPassword(newpw);
				break;
			case 2 :
				String newname = scanStr("변경할 이름을 입력하세요 : ");
				member2.setName(newname);
				break;
			case 3 : 
				String newphone = scanStr("변경할 연락처를 입력하세요 : ");
				member2.setPhone(newphone);
				break;
			default :
				System.out.println("=======================================");
				System.out.println("\t   잘못입력하였습니다.");
				System.out.println("=======================================");
				return;
			}
			
			service.updateMember(member2);
			System.out.println("=======================================");
			System.out.println("\t   회원정보를 변경하였습니다.");
			System.out.println("=======================================");
			
		}
	}
}

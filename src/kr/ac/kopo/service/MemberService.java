package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.RentalVO;

public class MemberService {

	private MemberDAO memberDao;

	public MemberService() {
		memberDao = new MemberDAO();
	}
	
	
	public void insertMember(MemberVO member) {
		memberDao.insertMember(member);
	}
	
	
	public void updateMember(MemberVO member) {
		memberDao.updateMember(member);
	}
	
	
	public void removeMember(MemberVO member) {
		memberDao.removeMember(member);
	}
	
	
	public List<MemberVO> selectAll() {
		List<MemberVO> memberList = memberDao.selectAllMember();
		return memberList;
	}
	
	
	public MemberVO selectById(String memberId) {
		MemberVO member = memberDao.selcetMemberById(memberId);
		return member;
	}

	
	public List<RentalVO> rentalMember(MemberVO member) {
		List<RentalVO> RentalList = memberDao.rentalMember(member);
		return RentalList;
	}

	
	public List<RentalVO> rentalAll(){
		List<RentalVO> RentalList = memberDao.rentalAll();
		return RentalList;
	}
	
}

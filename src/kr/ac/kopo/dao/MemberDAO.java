package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.RentalVO;


public class MemberDAO {
	
	
	
	public List<MemberVO> selectAllMember() {
		
		List<MemberVO> memberList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, password, name, phone ");
		sql.append("from t_member ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				MemberVO member = new MemberVO();
				member.setId(id);
				member.setPassword(password);
				member.setName(name);
				member.setPhone(phone);
				
				memberList.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	
	
	
	
	
	
	public MemberVO selcetMemberById(String memberid) {
		
		MemberVO member = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id,password,name,phone ");
		sql.append("from t_member ");
		sql.append("where id = ? ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			pstmt.setString(1, memberid);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				member = new MemberVO(id, password, name, phone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	
	
	
	
	
	public void updateMember(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("update t_member ");
		sql.append("set password = ? , name = ? , phone = ? ");
		sql.append("where id = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public void insertMember(MemberVO member) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_member(id,password,name,phone) ");
		sql.append("values( ? , ? , ? , ? ) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("=======================================");
			System.out.println("\t 이미 사용하고있는 아이디입니다.");
			System.out.println("=======================================");
			return;
		}
		System.out.println("=======================================");
		System.out.println("\t  회원가입을 완료하였습니다.");
		System.out.println("=======================================");
		
	}

	
	
	
	
	
	public void removeMember(MemberVO member) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_member ");
		sql.append("where id = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, member.getId());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	
	
	
	public List<RentalVO> rentalAll() {
		List<RentalVO> rentalList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, no, title, writer ");
		sql.append("from t_rental ");
		sql.append("order by id ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				
				RentalVO rental = new RentalVO();
				rental.setId(id);
				rental.setNo(no);
				rental.setTitle(title);
				rental.setWriter(writer);
				
				rentalList.add(rental);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rentalList;
	}


	
	
	
	
	
	public List<RentalVO> rentalMember(MemberVO member) {
		List<RentalVO> rentalList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select id, no, title, writer ");
		sql.append("from t_rental ");
		sql.append("where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, member.getId());
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");

				RentalVO rental = new RentalVO();
				rental.setId(id);
				rental.setNo(no);
				rental.setTitle(title);
				rental.setWriter(writer);
				
				rentalList.add(rental);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rentalList;
	}
	
	
}


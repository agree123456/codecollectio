package com.naver.contact.contactDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.naver.contact.contactutil.Dbconnection;
import com.naver.contact.dto.Contact;

@Repository
public class contactdao {
	
	public void ContactInsert(Contact dto) throws Exception {
		ContactInsert co = new ContactInsert();
		co.insert(dto);
	}
	
	public ArrayList<Contact> select() throws Exception{		
		Connection conn = Dbconnection.getConnection();
		String sql = "SELECT c.MEMBER_ID 							"
				+ ",c.NAME											"
				+ ",c.ADDRESS 										"
				+ ",c.PHONE 										"
				+ ",g.GROUPS_NAME 									"
				+ ",c.EMAIL 										"
				+ ",c.BIRTHDAY 										"
				+ "FROM GROUPS g ,  CONTACT c 						"
			    + "WHERE g.GROUPS_ID = c.GROUPS_ID					";
			ArrayList<Contact> list = new ArrayList<>();		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			try(conn;pstmt;rs) {
			while (rs.next()) {
				Contact dto = new Contact();
				dto.setMember_id(rs.getInt("member_id"));
				
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				dto.setPhone(rs.getInt("phone"));
				dto.setBirthday(rs.getDate("birthday"));
				dto.setGroups_name(rs.getString("groups_name"));
				dto.setEmail(rs.getString("email"));
				list.add(dto);
				}
			}
		return list;	
	}
	public Contact updateone(int member_id) throws Exception{
		
		Connection conn = Dbconnection.getConnection();
		StringBuilder sql = new  StringBuilder();
		sql.append("select c.NAME ");
		sql.append("     , c.ADDRESS ");
		sql.append("	 , c.PHONE ");
		sql.append("	 , c.GROUPS_ID ");
		sql.append("	 , c.EMAIL ");
		sql.append(" 	 , c.BIRTHDAY ");
		sql.append("     , c.member_ID");
		sql.append("  FROM CONTACT c");
		sql.append(" WHERE c.MEMBER_ID = ?");
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1, member_id);
		Contact dto = new Contact();
		ResultSet rs = pstmt.executeQuery();
		try(conn;pstmt;rs) { 
			
			while(rs.next()){// 받은 결과값을 arraylist에 넣기
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				dto.setPhone(rs.getInt("phone"));
				dto.setGroups_id(rs.getInt("groups_id"));
				dto.setEmail(rs.getString("email"));
		    	dto.setBirthday(rs.getDate("birthday"));
		    	dto.setMember_id(rs.getInt("member_id"));	    	
		    	
	
			}
			
	}
		return dto;
	
	
}
	public void updatetwo(Contact dto) throws Exception {
		updatetwo ups = new updatetwo();
		ups.updatenew(dto);
	}
	public void Delect(int member_id) throws Exception {
		Delect de = new Delect();
		de.DelContact(member_id);
	}
}


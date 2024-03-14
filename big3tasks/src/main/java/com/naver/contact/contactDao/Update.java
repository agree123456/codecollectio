package com.naver.contact.contactDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.naver.contact.contactutil.Dbconnection;
import com.naver.contact.dto.Contact;

public class Update {
	public Update() {

	}
	public ArrayList<Contact> updateone(int member_id) throws Exception{
		Contact cdto = new Contact();
		Connection conn = Dbconnection.getConnection();
		
		
		ArrayList<Contact> list = new ArrayList<Contact>();
		StringBuilder sql = new  StringBuilder();
		sql.append("select c.NAME ");
		sql.append("     , c.ADDRESS ");
		sql.append("	 , c.PHONE ");
		sql.append("	 , c.GROUPS_id ");
		sql.append("	 , c.EMAIL ");
		sql.append(" 	 , c.BIRTHDAY ");
		sql.append("     , c.member_id");
		sql.append("  FROM GROUPS g ,  CONTACT c");
		sql.append(" WHERE g.GROUPS_ID = c.GROUPS_ID");
		sql.append("   and  c.MEMBER_ID = ?");  
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		try(conn;pstmt;rs) {
			pstmt.setInt(1, member_id);
			
			while(rs.next()){// 받은 결과값을 arraylist에 넣기
		    	cdto.setMember_id(rs.getInt("member_id"));	    	
		    	cdto.setName(rs.getString("name"));
		    	cdto.setAddress(rs.getString("address"));
		    	cdto.setBirthday(rs.getDate("birthday"));
		    	cdto.setEmail(rs.getString("email"));
		    	cdto.setPhone(rs.getInt("phone"));
		    	cdto.setGroups_id(rs.getInt("groups_id"));
		    	list.add(cdto);
		    	System.out.println(cdto);
			}
			
	}return list;
	
}
}
package com.naver.contact.contactDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.naver.contact.contactutil.Dbconnection;
import com.naver.contact.dto.Contact;


public class updatetwo {
	public updatetwo() {
	}
	public void updatenew(Contact dto) throws Exception {
		Connection conn = Dbconnection.getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE CONTACT");
		sql.append("   SET NAME 	  = ?");
		sql.append("     , ADDRESS 	  = ?");
		sql.append("     , PHONE  	  = ?");
		sql.append("     , GROUPS_ID  = ?");
		sql.append("     , EMAIL 	  = ?");
		sql.append("     , BIRTHDAY   = ?");
		sql.append(" WHERE MEMBER_ID  = ?");
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		try(conn;pstmt) {
			pstmt.setString(1,dto.getName());
			pstmt.setString(2, dto.getAddress());
			pstmt.setInt(3, dto.getPhone());
			pstmt.setInt(4, dto.getGroups_id());
			pstmt.setString(5, dto.getEmail());
			pstmt.setDate(6, dto.getBirthday());
			pstmt.setInt(7, dto.getMember_id());
			pstmt.executeQuery();
		} 
		    
		     
		      
		      
		      
		     
		   
	}
	
}

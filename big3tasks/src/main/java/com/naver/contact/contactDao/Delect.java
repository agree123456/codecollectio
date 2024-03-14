package com.naver.contact.contactDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.naver.contact.contactutil.Dbconnection;




public class Delect {
	public Delect() {
	}
	public void DelContact(int member_id) throws Exception{
		Connection conn = Dbconnection.getConnection();		
		String sql = "delete from contact where member_id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try(conn;pstmt) {
			pstmt.setInt(1,member_id);
			pstmt.executeQuery();
		}
		
		
		
			
						
	}
}

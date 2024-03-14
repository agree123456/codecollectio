package com.naver.contact.contactDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.naver.contact.contactutil.Dbconnection;
import com.naver.contact.dto.Users;

public class UserInsert {
	public void UsersInsert(Users dto) {
		Connection conn = Dbconnection.getConnection();
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO USERSs u 									");
		sql.append("(u.USERID,u.USERPW										");
		sql.append(",u.NAME,u.NICKNAME										");	
		sql.append(",u.ADDRESS,u.PHOHE										");
		sql.append(",u.EMAIL,u.BIRTHDAY										");
		sql.append(",u.REGDATE											   )");
		sql.append("  values(?,?,?,?,?,?,?,?,to_date(sysdate,'yyyy-mm-dd') )");
		try {
			pstmt =  conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getUserpw());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getAddress());
			pstmt.setInt(5, dto.getPhone());
			pstmt.setString(6, dto.getEmail());
			pstmt.setInt(7, dto.getBirthday());
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Dbconnection.close(conn);
		}
		
	}
}

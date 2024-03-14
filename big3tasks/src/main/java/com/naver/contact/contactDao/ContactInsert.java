package com.naver.contact.contactDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.naver.contact.contactutil.Dbconnection;
import com.naver.contact.dto.Contact;

public class ContactInsert {
	public ContactInsert() {
	}
	
	public void insert(Contact dto) throws Exception{
		Connection conn = Dbconnection.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("insert into CONTACT C");
		sql.append("(C.MEMBER_ID ,NAME ,ADDRESS");
		sql.append(",PHONE,GROUPS_ID,EMAIL,BIRTHDAY,REGDT)");	
		sql.append("values((select nvl(max(c.MEMBER_ID),0)+1 from CONTACT c)");
		sql.append(",?,?,?,?,?,?,to_date(sysdate,'yyyy-mm-dd'))");
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		try (conn;pstmt) {//sql넣기 및 db전송
			pstmt.setString(1, dto.getName());
			pstmt.setString(2,dto.getAddress());
			pstmt.setInt(3, dto.getPhone());
			pstmt.setInt(4, dto.getGroups_id());
			pstmt.setString(5,dto.getEmail());
			pstmt.setDate(6,dto.getBirthday());
			pstmt.execute(); 
		}
		
	}
}

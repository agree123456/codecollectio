package com.naver.contact.contactDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.naver.contact.contactutil.Dbconnection;
import com.naver.contact.dto.Contact;

public class Select {

	public ArrayList<Contact> select() throws Exception{
		Contact dto = new Contact();
		Connection conn = Dbconnection.getConnection();
		String sql = "SELECT c.MEMBER_ID ,c.NAME,c.ADDRESS ,c.PHONE 	"
				   + " ,g.GROUPS_NAME ,c.EMAIL ,c.BIRTHDAY 				"
				   + "FROM GROUPS g ,  CONTACT c 						"
				   + "WHERE g.GROUPS_ID = c.GROUPS_ID					";
			ArrayList<Contact> list = new ArrayList<>();		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			try(conn;pstmt;rs) {
			while (rs.next()) {
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
}

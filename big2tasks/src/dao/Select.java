package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import dto.ContactDto;


public class Select {
	public static ArrayList<ContactDto> selectall(){
	//sql 와 java 연동준비를 위한 driver 선언
	 String driver = "oracle.jdbc.driver.OracleDriver";
	 String url = "jdbc:oracle:thin:@localhost:1521:xe";
	 String userid = "ora_user";
	 String password = "1234";
	//db에 연결을 위한 변수들
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// 퀴리문 
	StringBuilder sql = new StringBuilder();
    sql.append("SELECT M.MEMBER_ID  				");    
    sql.append("     , M.MEMBER_NAME				");
    sql.append("     , M.ADDRESS                    ");
    sql.append("     , M.PHONENUMBER 				");
    sql.append("     , M.GROUPS_ID  				");
    sql.append("  FROM MEMBERS M            		");

    // 데이터 값을 불러온후 저장할 곳
    ArrayList<ContactDto> alist= new  ArrayList<>(); 
    
    try {//드라이브로딩
		Class.forName(driver);
		//드라이브 로딩
		conn = DriverManager.getConnection(url, userid, password);
		pstmt = conn.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();
		while (rs.next()) {
			//cdto를 사용하기위해 선언
			ContactDto cdto = new ContactDto();
			// cdto에 내용넣기
			cdto.setMember_id(rs.getInt("member_id"));//db에서  cdto에 삽입
			cdto.setMember_name(rs.getString("member_name"));//db에서  cdto에 삽입
			cdto.setAddress(rs.getString("address"));//db에서  cdto에 삽입
			cdto.setPhonenumber(rs.getString("phonenumber"));//db에서  cdto에 삽입
			cdto.setGroups_id(rs.getString("group_name"));//db에서  cdto에 삽입
			alist.add(cdto);
			}// 반복문을 활용하여 인원에 대해 번호 부여
		for(int i= 0; i<alist.size();i++) {
		System.out.println(alist.get(i));
		}
	} catch (ClassNotFoundException e) {//오류 메세지를 보여주기 위한 catch문
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {// 드라이버 정지
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
	}
	return alist;
    
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
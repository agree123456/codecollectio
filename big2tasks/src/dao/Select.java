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
	//sql �� java �����غ� ���� driver ����
	 String driver = "oracle.jdbc.driver.OracleDriver";
	 String url = "jdbc:oracle:thin:@localhost:1521:xe";
	 String userid = "ora_user";
	 String password = "1234";
	//db�� ������ ���� ������
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// ������ 
	StringBuilder sql = new StringBuilder();
    sql.append("SELECT M.MEMBER_ID  				");    
    sql.append("     , M.MEMBER_NAME				");
    sql.append("     , M.ADDRESS                    ");
    sql.append("     , M.PHONENUMBER 				");
    sql.append("     , M.GROUPS_ID  				");
    sql.append("  FROM MEMBERS M            		");

    // ������ ���� �ҷ����� ������ ��
    ArrayList<ContactDto> alist= new  ArrayList<>(); 
    
    try {//����̺�ε�
		Class.forName(driver);
		//����̺� �ε�
		conn = DriverManager.getConnection(url, userid, password);
		pstmt = conn.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();
		while (rs.next()) {
			//cdto�� ����ϱ����� ����
			ContactDto cdto = new ContactDto();
			// cdto�� ����ֱ�
			cdto.setMember_id(rs.getInt("member_id"));//db����  cdto�� ����
			cdto.setMember_name(rs.getString("member_name"));//db����  cdto�� ����
			cdto.setAddress(rs.getString("address"));//db����  cdto�� ����
			cdto.setPhonenumber(rs.getString("phonenumber"));//db����  cdto�� ����
			cdto.setGroups_id(rs.getString("group_name"));//db����  cdto�� ����
			alist.add(cdto);
			}// �ݺ����� Ȱ���Ͽ� �ο��� ���� ��ȣ �ο�
		for(int i= 0; i<alist.size();i++) {
		System.out.println(alist.get(i));
		}
	} catch (ClassNotFoundException e) {//���� �޼����� �����ֱ� ���� catch��
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {// ����̹� ����
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
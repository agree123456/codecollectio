package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dto.ContactDto;
import util.Dbconnection;

public class Delect { 
	public static ArrayList<ContactDto> contactDelete(Scanner scan){

//		����
		Connection conn 		   = Dbconnection.getConnection();
//		�÷��� ����
		ArrayList<ContactDto> alist = new ArrayList<ContactDto>();
		
		try {
//		pstmt, rs ����
			PreparedStatement pstmt 	= null;
			ResultSet rs 				= null;
//		sql ����
			StringBuilder sql = new StringBuilder();
			//db���� �̸����� �˻�
			sql.append("SELECT 	M.MEMBER_ID							");
			sql.append("	, 	M.MEMBER_NAME						");
			sql.append("	,	M.ADDRESS 							");
			sql.append("	,	M.PHONENUMBER  						");
			sql.append("	,	M.GROUPS_ID   						");
			sql.append("FROM 	MEMBERS M  							");
			sql.append("WHERE 	M.MEMBER_NAME LIKE '%' || ? || '%' 	");
			
//			DB�� ������ �������� sql ������ ��� �ޱ�
			pstmt=conn.prepareStatement(sql.toString());
			System.out.println("ȸ���� �����մϴ�.");
			System.out.print("�̸� �˻� : ");
			//�̸�����  db���� ������ ã�´�.
			pstmt.setString(1, scan.nextLine());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {//��񿡼� ���� ������ cdto�� ����
				ContactDto cdto = new ContactDto();
				cdto.setMember_id(rs.getInt("member_id"));
				cdto.setMember_name(rs.getString("member_name"));
				cdto.setAddress(rs.getString("address"));
				cdto.setPhonenumber(rs.getString("phonenumber"));
				cdto.setGroups_id(rs.getString("groups_id"));
				
				alist.add(cdto);
			}
//			aList�� ���� �˻� ��� ��ȸ
			if(alist.isEmpty()) {//����� �޴��� ������.
				System.out.println("�˻� ����� �����ϴ�. �ʱ�ȭ������ ���ư��ϴ�.");
				System.out.println();
				}	else {
					System.out.println("�˻� ��� ��ȸ");
					for(int i=0; i<alist.size(); i++) {
						System.out.print(i + ". ");
						System.out.println(alist.get(i));
						}
				}
		}	
		 catch (SQLException e) {
			e.printStackTrace();
		}
			System.out.print("������ ��ȣ �Է� : ");
			int index = scan.nextInt();
			System.out.println(alist.get(index));
//			index�� �ش��ϴ� value ��������
		try {
			//sql�� ����� pstmt����
			PreparedStatement pstmt = null;
			// ������ ���� sql�� 
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE  FROM MEMBERS M		");
			sql.append("WHERE   M.MEMBER_ID  = ?	");
			//member_id�� ã�Ƽ� ������Ų��.
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, alist.get(index).getMember_id());
			pstmt.executeUpdate();
			//sql�� �ڹٿ��� db�� �����Ͽ� �����ϴ°�
			System.out.println("���� �Ϸ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Dbconnection.close(conn);
		}
		return alist;
	}
}
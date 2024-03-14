package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import dto.ContactDto;

public class Insert extends ContactDto{

		public static void insert(Scanner scan) {
			
			ContactDto cdto1 = new ContactDto();
			
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userid = "ora_user";
			String password = "1234";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			//sql �μ�Ʈ �� �ι�°���̺� ������̵� ������ �μ�Ʈ ���� 
			 String sql  = "INSERT INTO MEMBERS (MEMBER_ID,MEMBER_NAME,ADDRESS,PHONENUMBER, GROUP_NAME )"
			             + "             values (sql_sql1.nextval,?,?,?,?)	                			";
			 String sql1 = "            DELETE GROUPS member_id;								        ";
			 String sql2 = "INSERT INTO GROUPS g2 (g2.MEMBER_ID)									    "
			             + "            SELECT m.member_id											    "
			             + "              FROM MEMBERS m  											    ";   
//			1. Driver Loading
			try {
				Class.forName(driver);
//			2. Connection
				conn = DriverManager.getConnection(url, userid, password);
				//sql���� ������ ����
				pstmt = conn.prepareStatement(sql);
				pstmt = conn.prepareStatement(sql1);
				pstmt = conn.prepareStatement(sql2);
		
				while(true) {// �̸� �Է�
					System.out.print("�̸��Է�(�ʼ�) : ");// �ʼ� �Է�, ���� �ȵǰ� ó��
					String name = scan.nextLine();
					if(name.isBlank()) {
						
						System.out.println("321!�ٽ� �Է��ϼ���");
						
						
					}
					else {	
						cdto1.setMember_name(name);break;
					}
				}
			
				while(true) {// �ּ� �Է�
					System.out.print("�ּ��Է�(�ʼ�) : ");// �ʼ� �Է�, ���� �ȵǰ� ó��
					String address = scan.nextLine();
					if(address.isBlank()) {
						
						System.out.println("�ٽ� �Է��ϼ���");
					}
					else {	

				cdto1.setAddress(address);break;
					}
				}
				while(true) {// ��ȭ��ȣ�Է�
				try{
					System.out.print("��ȭ��ȣ�Է�(�ʼ�) : ");//�ʼ��Է�,01012341234 ���ڷθ� �Է�ó��	
					String a = scan.nextLine();
		            Long.parseLong(a);
		            if(a.length()==11) {
		           cdto1.setPhonenumber(a);}
		            else {
		            	System.out.println("��ȣ�Է��� �߸��Ǿ����ϴ�.");
		            	continue;
		            }
		        }
		        catch (NumberFormatException ex){
		            System.out.println("���ڷ� �Է��ϼ���!");
		            continue;
		        }break;
		        }
				
				System.out.print("�׷��Է�(�ɼ�) : ");//�ɼ�: ���� �ڵ����� ���õǰ� ��
				System.out.println("1.���� 2.ģ�� 3.ȸ�� 4.��Ÿ");
				String as = scan.nextLine();
				switch (as) {	
				case "1":
					cdto1.setGroups_id("����");	break;
				case "2":
					cdto1.setGroups_id("ģ��");	break;		
				case "3":
					cdto1.setGroups_id("ȸ��");	break;
				case "4":
					cdto1.setGroups_id("��Ÿ");	break;
				
				}//�Ѹ� ȸ������ �Է� �Ϸ�
				
//				4 ���� ���� => Ű����� �Է�

				pstmt.setString(1, cdto1.getMember_name()); 
				pstmt.setString(2, cdto1.getAddress()); 
				pstmt.setString(3, cdto1.getPhonenumber());
				pstmt.setString(4, cdto1.getGroups_id());
//				insert ����
				pstmt.executeUpdate(); // sql�� �����Ͽ��߰���Ű�� ����
								
//				pstmt,conn���� �����Ű�°�?����̺� ����
				pstmt.close();
				conn.close();
				System.out.println(cdto1);
			} catch (SQLException e) {// sql �������
				e.printStackTrace();}
				 catch (ClassNotFoundException e) {
						e.printStackTrace();
					
				 }
		}
	}



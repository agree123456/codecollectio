package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dto.ContactDto;
import util.Dbconnection;

public class Update {

	
	public static ArrayList<ContactDto> memberupdate(Scanner scan){
	// Scanner scan = new Scanner(System.in);
	ContactDto cdto = new ContactDto();	
	Connection conn = Dbconnection.getConnection();
	ArrayList<ContactDto> alist = new ArrayList<ContactDto>();
	StringBuilder disable = new StringBuilder(); // Ȱ��ȭ
	 	disable.append("ALTER TABLE GROUPS");
	 	disable.append("DISABLE CONSTRAINTS FK_MEMBERS_MEMBER_ID ");
	StringBuilder enable = new StringBuilder(); // ��Ȱ��ȭ
	 	enable.append("ALTER TABLE GROUPS ");
	 	enable.append("ENABLE CONSTRAINTS FK_MEMBERS_MEMBER_ID ");
	try {
		//pstmt , rs, sql ��������� sql�� ���� ���� �ۼ�
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT M.MEMBER_ID  					 ");    
	    sql.append("     , M.MEMBER_NAME					 ");
	    sql.append("     , M.ADDRESS                     	 ");
	    sql.append("     , M.PHONENUMBER 					 ");
	    sql.append("     , M.GROUPS_ID  					 ");
	    sql.append("  FROM MEMBERS M            		   	 ");
	    sql.append(" WHERE M.MEMBER_NAME LIKE '%'||?||'%'    ");
	    pstmt = conn.prepareStatement(sql.toString());
	    System.out.println("������ ȸ�������� �Է��ϼ���");
	    String membername = scan.nextLine();
	    pstmt.setString(1, membername);
	    rs = pstmt.executeQuery();
	    while(rs.next()){// ���� ������� arraylist�� �ֱ�
	    	cdto.setMember_id(rs.getInt("member_id"));
	    	cdto.setMember_name(rs.getString("member_name"));
	    	cdto.setAddress(rs.getString("address"));
	    	cdto.setPhonenumber(rs.getString("phonenumber"));
	    	cdto.setGroups_id(rs.getString("groups_id"));
	    	alist.add(cdto);
						}
	   
	    
	    }catch (SQLException e) {

			e.printStackTrace();

		}
	if(alist.isEmpty()) {//�˻���� �� ��ġ��
		System.out.println("��ġ�ϴ� ȸ���� �����ϴ�.");
	}
	else {// �˻� ����� ������
		System.out.println("�˻� ��� ��ȸ");

		for(int i=0; i<alist.size(); i++) {
			System.out.print(i + ". ");
			System.out.println(alist.get(i));}
		//�ߺ�������ó���� ���� �ε���
		int index = scan.nextInt();

//		System.out.println(alist.get(index));
		// �����̵�� where���� ������̵�� ã�´�
		int ins = alist.get(index).getMember_id();
		System.out.println(ins);
		try {//pstmt����� sql���� �ҽ� group���̺�� members���̺� �ִ� ������̵� ��ġ�� ������ ���� �Ѵ�,.
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder(); 
		sql.append("UPDATE MEMBERS M				  	 ");
		sql.append("   SET M.MEMBER_NAME =  ?			 ");
		sql.append("   ,   M.ADDRESS = 		?	 		 ");
		sql.append("   ,   M.PHONENUMBER =  ?			 ");
		sql.append("   ,   M.GROUPS_ID =	?			 ");
		sql.append(" WHERE M.MEMBER_ID =	?			 ");
		System.out.println("ȸ������ ����.");
		
		scan.nextLine();
		pstmt = conn.prepareStatement(sql.toString());
		while(true) {//�̸� ����� �ٽ��Է¹ް��Ѵ�
		System.out.print("�̸��Է�(�ʼ�) : ");
		String name = scan.nextLine();
		if(name.isBlank()) {
			System.out.println("������ �Է��Ͽ� �ٽ� �Էº�Ź�մϴ�.");
			continue;

			} else if(name.equals("1")) {//������ ������ ������ ����
				cdto.setMember_name(alist.get(index).getMember_name());
				break;
			}else {
				cdto.setMember_name(name);// ������ �̸��ֱ�
			
				break;
				}
		}
		while(true) {// �ּ� �Է�
			System.out.print("�ּ��Է�(�ʼ�) : ");// �ʼ� �Է�, ���� �ȵǰ� ó��
			String address = scan.nextLine();
			if(address.isBlank()) {
				
				System.out.println("�ٽ� �Է��ϼ���");
			}
			else {	

		cdto.setAddress(address);break;
			}
		}
		while(true) {// ��ȭ��ȣ�Է�
		try{
			System.out.print("��ȭ��ȣ�Է�(�ʼ�) : ");//�ʼ��Է�,01012341234 ���ڷθ� �Է�ó��	
			String a = scan.nextLine();
            Long.parseLong(a);
            if(a.length()==11) {
           cdto.setPhonenumber(a);//������ ��ȣ ����
           }
 
            	else if(a.equals("1")) {//������ ������ ������ ����
    				cdto.setMember_name(alist.get(index).getMember_name());
    				break;
            }
            else {// �ѱ��̳� ������ �߻��� �ٽ� �ۼ��ϰ� �Ѵ�.��
            	System.out.println("��ȣ�Է��� �߸��Ǿ����ϴ�.");
            	continue;
            }
        }
        catch (NumberFormatException ex){
            System.out.println("���ڷ� �Է��ϼ���!");
            continue;
        }break;
        }
		
		System.out.print("���ϴ� �׷��� ��ȣ�� �Է��ϼ��� : ");//�ɼ�: ������ �ִ�.//������ �����ϹǷ� �ٽ� �Է¹ް��Ѵ�.
		System.out.println("1.���� 2.ģ�� 3.ȸ�� 4.��Ÿ");
		String as = scan.nextLine();
		switch (as) {	
		case "1":
			cdto.setGroups_id("10");	break;
		case "2":
			cdto.setGroups_id("20");	break;		
		case "3":
			cdto.setGroups_id("30");	break;
		case "4":
			cdto.setGroups_id("40");	break;
		
				}
		//cdto�� �ִ°� pstmt�� sql�� �����Ų��.
		pstmt.setString(1, cdto.getMember_name()); 
		pstmt.setString(2, cdto.getAddress()); 
		pstmt.setString(3, cdto.getPhonenumber());
		pstmt.setString(4, cdto.getGroups_id());
		pstmt.setInt(5, cdto.getMember_id());;
		pstmt.executeUpdate();
		}
		
		catch (SQLException e) {
				e.printStackTrace();
			}
	

			finally {// conn.close
	Dbconnection.close(conn);		
			}
	}
	return alist;
	}
}
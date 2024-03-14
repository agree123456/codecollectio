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
	StringBuilder disable = new StringBuilder(); // 활성화
	 	disable.append("ALTER TABLE GROUPS");
	 	disable.append("DISABLE CONSTRAINTS FK_MEMBERS_MEMBER_ID ");
	StringBuilder enable = new StringBuilder(); // 비활성화
	 	enable.append("ALTER TABLE GROUPS ");
	 	enable.append("ENABLE CONSTRAINTS FK_MEMBERS_MEMBER_ID ");
	try {
		//pstmt , rs, sql 변수선언및 sql에 보낼 구문 작성
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
	    System.out.println("수정할 회원정보를 입력하세요");
	    String membername = scan.nextLine();
	    pstmt.setString(1, membername);
	    rs = pstmt.executeQuery();
	    while(rs.next()){// 받은 결과값을 arraylist에 넣기
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
	if(alist.isEmpty()) {//검색결과 불 일치시
		System.out.println("일치하는 회원이 없습니다.");
	}
	else {// 검색 대상이 있을시
		System.out.println("검색 대상 조회");

		for(int i=0; i<alist.size(); i++) {
			System.out.print(i + ". ");
			System.out.println(alist.get(i));}
		//중복데이터처리를 위한 인덱스
		int index = scan.nextInt();

//		System.out.println(alist.get(index));
		// 업데이드시 where절에 멤버아이디로 찾는다
		int ins = alist.get(index).getMember_id();
		System.out.println(ins);
		try {//pstmt선언및 sql선언 할시 group테이블과 members테이블에 있는 멤버아이디가 일치시 수정에 들어가게 한다,.
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder(); 
		sql.append("UPDATE MEMBERS M				  	 ");
		sql.append("   SET M.MEMBER_NAME =  ?			 ");
		sql.append("   ,   M.ADDRESS = 		?	 		 ");
		sql.append("   ,   M.PHONENUMBER =  ?			 ");
		sql.append("   ,   M.GROUPS_ID =	?			 ");
		sql.append(" WHERE M.MEMBER_ID =	?			 ");
		System.out.println("회원정보 수정.");
		
		scan.nextLine();
		pstmt = conn.prepareStatement(sql.toString());
		while(true) {//이름 공백시 다시입력받게한다
		System.out.print("이름입력(필수) : ");
		String name = scan.nextLine();
		if(name.isBlank()) {
			System.out.println("공백을 입력하여 다시 입력부탁합니다.");
			continue;

			} else if(name.equals("1")) {//수정이 없을시 기존값 삽입
				cdto.setMember_name(alist.get(index).getMember_name());
				break;
			}else {
				cdto.setMember_name(name);// 수정된 이름넣기
			
				break;
				}
		}
		while(true) {// 주소 입력
			System.out.print("주소입력(필수) : ");// 필수 입력, 공백 안되게 처리
			String address = scan.nextLine();
			if(address.isBlank()) {
				
				System.out.println("다시 입력하세요");
			}
			else {	

		cdto.setAddress(address);break;
			}
		}
		while(true) {// 전화번호입력
		try{
			System.out.print("전화번호입력(필수) : ");//필수입력,01012341234 숫자로만 입력처리	
			String a = scan.nextLine();
            Long.parseLong(a);
            if(a.length()==11) {
           cdto.setPhonenumber(a);//수정된 번호 삽입
           }
 
            	else if(a.equals("1")) {//수정이 없을시 기존값 삽입
    				cdto.setMember_name(alist.get(index).getMember_name());
    				break;
            }
            else {// 한글이나 공백이 발생시 다시 작성하게 한다.ㄴ
            	System.out.println("번호입력이 잘못되었습니다.");
            	continue;
            }
        }
        catch (NumberFormatException ex){
            System.out.println("숫자로 입력하세요!");
            continue;
        }break;
        }
		
		System.out.print("원하는 그룹의 번호를 입력하세요 : ");//옵션: 있을수 있다.//수정이 용이하므로 다시 입력받게한다.
		System.out.println("1.가족 2.친구 3.회사 4.기타");
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
		//cdto에 있는걸 pstmt로 sql에 적재시킨다.
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
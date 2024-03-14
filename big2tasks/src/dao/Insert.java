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
			//sql 인서트 및 두번째테이블에 멤버아이디를 삭제및 인서트 과정 
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
				//sql문을 나눠서 전송
				pstmt = conn.prepareStatement(sql);
				pstmt = conn.prepareStatement(sql1);
				pstmt = conn.prepareStatement(sql2);
		
				while(true) {// 이름 입력
					System.out.print("이름입력(필수) : ");// 필수 입력, 공백 안되게 처리
					String name = scan.nextLine();
					if(name.isBlank()) {
						
						System.out.println("321!다시 입력하세요");
						
						
					}
					else {	
						cdto1.setMember_name(name);break;
					}
				}
			
				while(true) {// 주소 입력
					System.out.print("주소입력(필수) : ");// 필수 입력, 공백 안되게 처리
					String address = scan.nextLine();
					if(address.isBlank()) {
						
						System.out.println("다시 입력하세요");
					}
					else {	

				cdto1.setAddress(address);break;
					}
				}
				while(true) {// 전화번호입력
				try{
					System.out.print("전화번호입력(필수) : ");//필수입력,01012341234 숫자로만 입력처리	
					String a = scan.nextLine();
		            Long.parseLong(a);
		            if(a.length()==11) {
		           cdto1.setPhonenumber(a);}
		            else {
		            	System.out.println("번호입력이 잘못되었습니다.");
		            	continue;
		            }
		        }
		        catch (NumberFormatException ex){
		            System.out.println("숫자로 입력하세요!");
		            continue;
		        }break;
		        }
				
				System.out.print("그룹입력(옵션) : ");//옵션: 고르면 자동으로 선택되게 됨
				System.out.println("1.가족 2.친구 3.회사 4.기타");
				String as = scan.nextLine();
				switch (as) {	
				case "1":
					cdto1.setGroups_id("가족");	break;
				case "2":
					cdto1.setGroups_id("친구");	break;		
				case "3":
					cdto1.setGroups_id("회사");	break;
				case "4":
					cdto1.setGroups_id("기타");	break;
				
				}//한명 회원정보 입력 완료
				
//				4 값을 세팅 => 키보드로 입력

				pstmt.setString(1, cdto1.getMember_name()); 
				pstmt.setString(2, cdto1.getAddress()); 
				pstmt.setString(3, cdto1.getPhonenumber());
				pstmt.setString(4, cdto1.getGroups_id());
//				insert 실행
				pstmt.executeUpdate(); // sql을 실행하여추가시키는 구문
								
//				pstmt,conn연결 종료시키는것?드라이브 종료
				pstmt.close();
				conn.close();
				System.out.println(cdto1);
			} catch (SQLException e) {// sql 오류잡기
				e.printStackTrace();}
				 catch (ClassNotFoundException e) {
						e.printStackTrace();
					
				 }
		}
	}



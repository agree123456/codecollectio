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

//		연동
		Connection conn 		   = Dbconnection.getConnection();
//		컬렉션 선언
		ArrayList<ContactDto> alist = new ArrayList<ContactDto>();
		
		try {
//		pstmt, rs 선언
			PreparedStatement pstmt 	= null;
			ResultSet rs 				= null;
//		sql 선언
			StringBuilder sql = new StringBuilder();
			//db에서 이름으로 검색
			sql.append("SELECT 	M.MEMBER_ID							");
			sql.append("	, 	M.MEMBER_NAME						");
			sql.append("	,	M.ADDRESS 							");
			sql.append("	,	M.PHONENUMBER  						");
			sql.append("	,	M.GROUPS_ID   						");
			sql.append("FROM 	MEMBERS M  							");
			sql.append("WHERE 	M.MEMBER_NAME LIKE '%' || ? || '%' 	");
			
//			DB에 정보를 가져오고 sql 보내고 결과 받기
			pstmt=conn.prepareStatement(sql.toString());
			System.out.println("회원을 삭제합니다.");
			System.out.print("이름 검색 : ");
			//이름으로  db에서 정보를 찾는다.
			pstmt.setString(1, scan.nextLine());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {//디비에서 받은 정보를 cdto에 저장
				ContactDto cdto = new ContactDto();
				cdto.setMember_id(rs.getInt("member_id"));
				cdto.setMember_name(rs.getString("member_name"));
				cdto.setAddress(rs.getString("address"));
				cdto.setPhonenumber(rs.getString("phonenumber"));
				cdto.setGroups_id(rs.getString("groups_id"));
				
				alist.add(cdto);
			}
//			aList를 통한 검색 결과 조회
			if(alist.isEmpty()) {//공백시 메뉴로 나간다.
				System.out.println("검색 결과가 없습니다. 초기화면으로 돌아갑니다.");
				System.out.println();
				}	else {
					System.out.println("검색 대상 조회");
					for(int i=0; i<alist.size(); i++) {
						System.out.print(i + ". ");
						System.out.println(alist.get(i));
						}
				}
		}	
		 catch (SQLException e) {
			e.printStackTrace();
		}
			System.out.print("삭제할 번호 입력 : ");
			int index = scan.nextInt();
			System.out.println(alist.get(index));
//			index에 해당하는 value 가져오기
		try {
			//sql문 선언및 pstmt선언
			PreparedStatement pstmt = null;
			// 삭제를 윈한 sql문 
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE  FROM MEMBERS M		");
			sql.append("WHERE   M.MEMBER_ID  = ?	");
			//member_id로 찾아서 삭제시킨다.
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, alist.get(index).getMember_id());
			pstmt.executeUpdate();
			//sql을 자바에서 db로 적재하여 수정하는것
			System.out.println("삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Dbconnection.close(conn);
		}
		return alist;
	}
}
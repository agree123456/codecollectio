package controller;


import java.util.Scanner;
import dao.Insert;
import dao.Select;
import dao.Update;
import dao.Delect;
import util.ShowMenu;

public class ContactController {
	/*
	 *  요청처리
	 *  1. 회원추가, 2.회원목록, 3. 회원수정, 4.회원삭제, 5. 종료
	 *  데이터베이스 연동 개발순서
	 *  1. 쿼리를 실행, 테스트 진행(디비틀 사용)
	 *  2. DAO 개발
	 *  3. Service 개발
	 *  
	 *  4. Controller 개발
	 *  5. View 개발
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		while(true)
		{//메뉴판 보여주는곳
		ShowMenu.showmenu();
		String number = scan.next();
		System.out.println("선택한 번호"+ number);
		if(number.equals("1")) {// 회원추가를 위한곳
			Insert.insert(scan);//cdto에 있는걸 insert에 집어넣는곳
		}
		if(number.equals("2")) {//회원 조회를 하는곳
			Select.selectall();
		}
		if(number.equals("3")) {//회원 수정이 이루어지는곳
			Update.memberupdate(scan);
		}
		if(number.equals("4")) {//회원삭제를 하는곳
			Delect.contactDelete(scan);
		}
		if(number.equals("5")) {//종료
			System.out.println("종료됩니다.");
			break;
				}
			}
		scan.close();
		}
	
}
package controller;


import java.util.Scanner;
import dao.Insert;
import dao.Select;
import dao.Update;
import dao.Delect;
import util.ShowMenu;

public class ContactController {
	/*
	 *  ��ûó��
	 *  1. ȸ���߰�, 2.ȸ�����, 3. ȸ������, 4.ȸ������, 5. ����
	 *  �����ͺ��̽� ���� ���߼���
	 *  1. ������ ����, �׽�Ʈ ����(���Ʋ ���)
	 *  2. DAO ����
	 *  3. Service ����
	 *  
	 *  4. Controller ����
	 *  5. View ����
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		while(true)
		{//�޴��� �����ִ°�
		ShowMenu.showmenu();
		String number = scan.next();
		System.out.println("������ ��ȣ"+ number);
		if(number.equals("1")) {// ȸ���߰��� ���Ѱ�
			Insert.insert(scan);//cdto�� �ִ°� insert�� ����ִ°�
		}
		if(number.equals("2")) {//ȸ�� ��ȸ�� �ϴ°�
			Select.selectall();
		}
		if(number.equals("3")) {//ȸ�� ������ �̷�����°�
			Update.memberupdate(scan);
		}
		if(number.equals("4")) {//ȸ�������� �ϴ°�
			Delect.contactDelete(scan);
		}
		if(number.equals("5")) {//����
			System.out.println("����˴ϴ�.");
			break;
				}
			}
		scan.close();
		}
	
}
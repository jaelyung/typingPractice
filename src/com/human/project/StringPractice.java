package com.human.project;
import java.util.*;
//�ڹٷ� Ÿ�ڿ��������
//1.�޴�����(�ڸ�����/��������/ª���ۿ���/������ȸ/����)
//2.Ÿ�ڿ��� ���� 
//����ڰ� �Է��� �������(�迭)
//����� �Է¹ޱ�(�迭)
//�Է��� ���� char���� ���ϱ�
//3.����
public class StringPractice {
	public static int totalCount=0;//���� ����Ƚ��
	public SPUser[] user=new SPUser[10];
	public int userCount=0;
	public int userCurrent=-1;
	public StringPractice() {
		totalCount++;
	}
	
	public void accountAdd() {
		Scanner sc=new Scanner(System.in);
		System.out.println("���ϴ� ���̵� �Է�>>");
		String id=sc.nextLine();
		if(isId(id)) {
			System.out.println("�ߺ��� ���̵��Դϴ�.");
			return;
		}
		System.out.println("���ϴ� ��й�ȣ �Է�>>");
		String pw=sc.nextLine();
		user[userCount++]=new SPUser(id,pw);
		
	}
	private boolean isId(String id) {
		boolean returnValue=false;
		for(int i=0;i<userCount;i++) {
			if(user[i].id.equals(id)) {
				returnValue=true;
			}
		}
		return returnValue;
	}
	private void logout() {
		userCurrent=-1;
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
	}

	private boolean login(String id, String pw) {
		boolean returnValue=false;
		for(int i=0;i<userCount;i++) {
			if(user[i].isLogin(id,pw)) {
				returnValue=true;
				userCurrent=i;
				break;
			}
		}
		return returnValue;
		
	}
	private void useAccount() {
		if(userCurrent!=-1) {
			user[userCurrent].gameMenu();
		}else {
			System.out.println("�߸��� �α���");
		}
		
	}
	private void displayAll() {
		System.out.println("�� ������: "+StringPractice.totalCount);
		for(int i=0;i<userCount;i++) {
			user[i].display();
		}
	}
	public void menu() {
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1.�������  2.������ȸ  3.�α���  4.�α׾ƿ�  5.����");
			String userInput=sc.nextLine();
			switch(userInput) {
			case "1":
				accountAdd();
				break;
			case "2":
				displayAll();
				break;
			case "3":
				System.out.println("���̵� �Է�>>");
				String id=sc.nextLine();
				System.out.println("��й�ȣ �Է�>>");
				String pw=sc.nextLine();
				if(login(id,pw)) {
					System.out.println("�α��� �Ǿ����ϴ�.");
					useAccount();
				}else {
					System.out.println("�α��� ����");
				}
				break;
			case "4":
				logout();
				break;
			case "5":
				System.out.println("���α׷��� �����մϴ�.");
				flag=false;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}

	public static void main(String[] args) {
		StringPractice sp=new StringPractice();
		sp.menu();

	}

}

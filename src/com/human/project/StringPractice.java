package com.human.project;
import java.util.*;
//자바로 타자연습만들기
//1.메뉴생성(자리연습/낱말연습/짧은글연습/전적조회/종료)
//2.타자연습 시작 
//사용자가 입력할 문장띄우기(배열)
//사용자 입력받기(배열)
//입력한 문장 char별로 비교하기
//3.점수
public class StringPractice {
	public static int totalCount=0;//게임 실행횟수
	public SPUser[] user=new SPUser[10];
	public int userCount=0;
	public int userCurrent=-1;
	public StringPractice() {
		totalCount++;
	}
	
	public void accountAdd() {
		Scanner sc=new Scanner(System.in);
		System.out.println("원하는 아이디 입력>>");
		String id=sc.nextLine();
		if(isId(id)) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		System.out.println("원하는 비밀번호 입력>>");
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
		System.out.println("로그아웃 되었습니다.");
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
			System.out.println("잘못된 로그인");
		}
		
	}
	private void displayAll() {
		System.out.println("총 계정수: "+StringPractice.totalCount);
		for(int i=0;i<userCount;i++) {
			user[i].display();
		}
	}
	public void menu() {
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1.계정등록  2.계정조회  3.로그인  4.로그아웃  5.종료");
			String userInput=sc.nextLine();
			switch(userInput) {
			case "1":
				accountAdd();
				break;
			case "2":
				displayAll();
				break;
			case "3":
				System.out.println("아이디 입력>>");
				String id=sc.nextLine();
				System.out.println("비밀번호 입력>>");
				String pw=sc.nextLine();
				if(login(id,pw)) {
					System.out.println("로그인 되었습니다.");
					useAccount();
				}else {
					System.out.println("로그인 실패");
				}
				break;
			case "4":
				logout();
				break;
			case "5":
				System.out.println("프로그램을 종료합니다.");
				flag=false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}

	public static void main(String[] args) {
		StringPractice sp=new StringPractice();
		sp.menu();

	}

}
